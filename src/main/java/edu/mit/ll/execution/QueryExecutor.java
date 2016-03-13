package edu.mit.ll.execution;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.antlr.runtime.RecognitionException;

import unity.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.mit.ll.aexp.AExpProcessor;
import edu.mit.ll.datastoreutils.ConnectionManager;
import edu.mit.ll.datastoreutils.Joiner;
import edu.mit.ll.datastoreutils.Parser;
import edu.mit.ll.datastoreutils.SqlToMongoMapper;
import edu.mit.ll.datastoreutils.Utils;
import edu.mit.ll.php.JavaPhpSqlWrapper;

public class QueryExecutor {
	private List<String> queryList = new LinkedList<>();
	public void addQuery(String query){
		queryList.add(query);
	}
	public void executeQueryList() throws RecognitionException, ParseException, SQLException, IOException{
		this.persistConnection = true;
		
		String basefilename = "output/outfile";
		for(int i = 0; i<queryList.size();i++){
			String tempFileName = basefilename + Integer.toString(i);
			this.outputfile = new File(tempFileName);
			System.out.println("The file is:"+this.outputfile);
			System.out.println("The query is:"+this.queryList.get(i));
			Date d = new Date();
			this.setReturnResultObject(true);
			this.executeQuery(this.queryList.get(i));
			Date f = new Date();
			System.out.println("Executing individual statement time"+Long.toString(f.getTime()-d.getTime()));
		}
		this.con.close();
	}
	private String folderlocation;

	public void setFolderLocation(String folder)
	{
		File dot = new File(".").getAbsoluteFile();
		String s = dot.getAbsolutePath();
		s=s.substring(0,s.length()-1);
		this.folderlocation = s+folder;
	}
	//RowLimit.  After this amount of rows, print to file instead of returning an object a -1 is infinite
	private int rowLimit = -1;
	//Query to be executed
	private String query = "";
	//Connection to database
	private Connection con;
	//Output file
	private File outputfile = new File("OUTPUT/outfile");
	//Replacement string
	private String stringtoreplacewith = "XO";
	//String to match
	private String matchstring = "\\\\";

	private boolean persistConnection = false;
	private boolean returnResultObject = false;
	/**
	 * Returns the current row limit
	 * @return
	 */
	public int getRowLimit() {
		return rowLimit;
	}
	/**
	 * Sets the row limit
	 * @param rowLimit After this amount of rows, print to file instead of returning an object
	 */
	public void setRowLimit(int rowLimit) {
		this.rowLimit = rowLimit;
	}
	/**
	 * Initialize the object with custom values and create a connection
	 * @param query
	 * @param rowLimit
	 * @throws SQLException
	 * @throws MalformedURLException 
	 */
	public QueryExecutor(String query, int rowLimit) throws SQLException, MalformedURLException{
		this.rowLimit = rowLimit;
		this.query=query;
		
	}
	/**
	 * Initialize the object with default values and create a connection
	 * @throws SQLException 
	 * @throws MalformedURLException 
	 */
	public QueryExecutor() throws SQLException, MalformedURLException{
//		Date start = new Date();

//		System.out.println("Making a connection to: " + url);
//		initializeConnection(url, user, password);
//		System.out.println("Connection successful.\n");
//		Date finish = new Date();
//		long time = finish.getTime() - start.getTime();
//		System.out.println("It took this many seconds to initialize the connection:"+Long.toString(time));

	}

	public void initializeConnection() throws MalformedURLException, SQLException {
		// TODO Auto-generated method stub
		Date start = new Date();
		System.out.println("Making a connection to: " + url);
//		con = DriverManager.getConnection(url, "dbuser", "");
		URL connectionUrl = new URL(url);
		
		if(connectionUrl.getProtocol().contains("elk")){
			con = ConnectionManager.getELKConnection(url,user,password);
		}
		else{
			con = ConnectionManager.getDBConnection(url,user,password);
		}
		System.out.println("Connection successful.\n");
		Date finish = new Date();
		long time = finish.getTime() - start.getTime();
		System.out.println("It took this many seconds to initialize the connection:"+Long.toString(time));
			
			
	}
	/**
	 * Executes the query passed in and either saves it to a file or returns the result set from the query
	 * @param query
	 * @param rowLimit
	 * @return ResultSet of rows.  Needs to be closed later.
	 * @throws RecognitionException Thrown if AExp cannot be processed
	 * @throws ParseException  Thrown if final SQL expression cannot be processed
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public ResultSet executeQuery(String query, int rowLimit) throws RecognitionException, ParseException, SQLException, IOException{
		try{
			//Intermediate step will replace AExp with this string

			//Start time for metrics
			Date start = Calendar.getInstance().getTime();

			//Parses AExp from SQL query
			Parser p = new Parser(); //Extract A-Expressions and replace each with a substitute
			List<String> aexpqueries = p.stringExtractor(matchstring,query,stringtoreplacewith);

			//Transforms SQL query into a JSON Object for easier handling later
			JavaPhpSqlWrapper sqlprocessor = new JavaPhpSqlWrapper(aexpqueries.get(aexpqueries.size()-1));
			JsonParser parser = new JsonParser();
			sqlprocessor.enableDebug(this.debug);
			String phpres = sqlprocessor.execPHP(null,sqlprocessor.getQuery());
			if(debug)
				System.out.println(phpres);
			
			JsonObject result = (JsonObject)parser.parse(phpres);

			//Actual processor of AExp takes the AExp and parses, lexes and interprets it
			AExpProcessor procesor = new AExpProcessor();
			procesor.enableCaseInsensitive(this.caseInsensitive);
			procesor.enableDebug(this.debug);
			for(int i=0; i<aexpqueries.size()-1;i++){
				try {
					//Process the query and store the results inside the processor object
					procesor.process(aexpqueries.get(i),true);
				} catch (RecognitionException e) {
					e.printStackTrace();
					throw e;
				}
			}

			//We can print additional info before we actually print

			//Joins the result of the AExp with the SQL expression so it can be executed
			String sql = (new Joiner()).join(procesor.getStoredOperationResults(), p.lastResult(), stringtoreplacewith, result);

			//Wrapper to execute the sql query in mongo db
//			ResultSet finalresult = (new SqlToMongoMapper(sql)).runQuery(this.con, debug);

			//Finish time for metrics

			//Process wether to write to file or not
			
			String countsql = "SELECT COUNT(*) FROM ("+sql+") as Dummy";
			boolean printout = false;
			ResultSet countresult = ConnectionManager.runQuery(countsql,this.con, printout); //calls UnityJDBC
			boolean nextres = countresult.next();
			Object var = countresult.getObject(1);
			long count = Long.parseLong(var.toString());

			//If the # of rows is more than the limit we specified and it is not infinite then we print!
			if(count>this.getRowLimit() && (this.getRowLimit()!=-1)){
				ResultSet recall = (new SqlToMongoMapper(sql)).runQuery(this.con, false);
				setFolderLocation("output");
				outputfile = new File(folderlocation+"/"+outputfile.getName());
				if(!outputfile.isFile())
					outputfile.createNewFile();
				Utils.printResultToJson(recall, outputfile);
			}
			Date finish = new Date();

			//Done and metrics
			//			if(debug){
			System.out.println("Done.  Time to complete execution:");
			System.out.println("Start:"+start+" Finish:"+finish+" Duration in millis:"+Long.toString(finish.getTime()-start.getTime()));	
			//			}
			if(returnResultObject){
				SqlToMongoMapper mapr = new SqlToMongoMapper(sql);
				mapr.enableDebug(this.debug);
				return (mapr).runQuery(this.con, false);
			}
			else{
				return null;
			}
		}

		catch (SQLException ex)
		{
			System.out.println("Error making query: " + ex);
			ex.printStackTrace();
			throw ex;
		}
		catch (IOException ex){
			System.out.println("Error accessing file: " + ex);
			ex.printStackTrace();
			throw ex;
		}
		catch (RecognitionException ex){
			System.out.println("Error parsing AExp: " + ex);
			ex.printStackTrace();
			throw ex;
		}
		catch( ParseException ex){
			System.out.println("Error parsing sql query: " + ex);
			ex.printStackTrace();
			throw ex;
		}
		catch(Exception ex){
			System.out.println("Something went wrong: "+ex);
			ex.printStackTrace();
			throw ex;
		}
		finally
		{
			if (con != null)
			{
				try
				{
					// Close the connection
					if(!persistConnection)
						con.close();
				}
				catch (SQLException ex)
				{
					System.out.println("SQLException: " + ex);
				}
			}
		}

	}
	/**
	 * Execute the query passed in, uses stored row limit
	 * @param query
	 * @return
	 * @throws ParseException 
	 * @throws RecognitionException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public ResultSet executeQuery(String query) throws RecognitionException, ParseException, SQLException, IOException{
		return executeQuery(query,this.getRowLimit());
	}
	/**
	 * Should be run after the object has been built correctly. Works using the stored settings
	 * @return
	 * @throws ParseException 
	 * @throws RecognitionException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public ResultSet executeQuery() throws RecognitionException, ParseException, SQLException, IOException{
		return executeQuery(this.getQuery(),this.getRowLimit());
	}
	/**
	 * Returns the query that will be executed
	 * @return
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * Sets the query to be executed
	 * @param query
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	public File getOutputfile() {
		return outputfile;
	}
	public void setOutputfile(File outputfile) {
		this.outputfile = outputfile;
	}
	public void enableDebug(boolean debug) {
		this.debug = debug;
	}
	public String getReplacementString() {
		return stringtoreplacewith;
	}
	public void setReplacementString(String replacementString) {
		this.stringtoreplacewith = replacementString;
	}
	private boolean debug = false;
	private boolean caseInsensitive;
	private String url;
	private String user;
	private String password;
	public List<String> getQueryList() {
		return queryList;
	}
	public void setQueryList(List<String> queryList) {
		this.queryList = queryList;
	}
	public boolean isPersistConnection() {
		return persistConnection;
	}
	public void setPersistConnection(boolean persistConnection) {
		this.persistConnection = persistConnection;
	}
	public boolean isReturnResultObject() {
		return returnResultObject;
	}
	public void setReturnResultObject(boolean returnResultObject) {
		this.returnResultObject = returnResultObject;
	}
	public void enableCaseInsensitive(boolean b) {
		this.caseInsensitive = b;
		
	}
	public void setUrl(String optionValue) {
		// TODO Auto-generated method stub
		this.url = optionValue;
	}
	public void setUser(String optionValue) {
		// TODO Auto-generated method stub
		this.user = optionValue;
	}
	public void setPassword(String optionValue) {
		// TODO Auto-generated method stub
		this.password = optionValue;
	}
}
