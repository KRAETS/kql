package edu.mit.ll;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.CannotProceedException;

import org.antlr.runtime.RecognitionException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import edu.mit.ll.execution.QueryExecutor;

public class Main {
	private String url = "jdbc:mongo://localhost:27017/enron_mail_clean?rebuildschema=true";
	private QueryExecutor executor;
	private File jsonOutput = new File("jout.json");
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws unity.parser.ParseException 
	 * @throws RecognitionException 
	 * @throws CannotProceedException 
	 */
	public static void main(String[] args) throws SQLException, RecognitionException, unity.parser.ParseException, IOException, CannotProceedException {
		// TODO Auto-generated method stub
		// create Options object
		Options options = new Options();

		// add t option
		options.addOption("kqlq","kql-query", true, "input sql query");
		options.addOption("d", "debug", false, "Enables debugging messages");
		//options.addOption("json", "json-output", false, "Outputs data in json format");
		options.addOption("fol", "file-output-limit", true, "Limit of rows before printing result to file");
		options.addOption("out", "output-file", true, "File with results from query");
		options.addOption("ci","case-insensitive", false,"Case insensitivity for Dimenaions and tags");
		options.addOption("url", "url",true,"Data store url");
		options.addOption("u","user",true,"Data store user");
		options.addOption("p","password", true, "Data store password");
		Option option = new Option("ql", "query-list");
		// Set option c to take 1 to oo arguments
		option.setArgs(Option.UNLIMITED_VALUES); //This must be the last option
		options.addOption(option);
		
		
		HelpFormatter formatter = new HelpFormatter();
		
		
		CommandLineParser parser = new DefaultParser();
		
		boolean jsonoutput = true,debug = false;
		File output = null;
		int fol = 100;
		Main m = new Main();
		QueryExecutor executor = m.instantiateExecutor();
		executor.enableDebug(debug);

		
		try {
			//Parse the options
			CommandLine cmd = parser.parse( options, args);
			
			//Check required parameters
			if( cmd.hasOption( "kqlq" )) {
		        // print the value of block-size
				m.setQuery(cmd.getOptionValue("kqlq").toString());
				m.setRowLimit(100);
				
				System.out.println("Input query:");
		        System.out.println( cmd.getOptionValue( "kqlq" ) );
		    }
			else if(cmd.hasOption("ql")){
				String[] ov = cmd.getOptionValues("ql");
				List<String> querylist = new ArrayList<>(Arrays.asList(ov));
				executor.setQueryList(querylist);
			}
			else{
				System.err.println("Query not specified... Exiting...");
				formatter.printHelp( "kql", options );
				return;
			}
			//Optional parameters
			if( cmd.hasOption( "fol" ) ) {
		        // print the value of block-size
				String fol1 = cmd.getOptionValue("fol");
				int folint = Integer.parseInt(fol1.trim());
				m.setRowLimit(folint);
				
				System.out.println("Input fol:");
		        System.out.println( cmd.getOptionValue( "fol" ) );
		    }
			else{
				//formatter.printHelp( "kql", options );
				System.out.println("Using default: "+fol);
			}
			
			if( cmd.hasOption( "debug" ) ) {
		        // print the value of block-size
				m.enableDebug(true);
		        System.out.println( "Debugging enabled" );
		    }
			else{
				System.out.println("Using default debug setting: "+debug);
			}
			
			if( cmd.hasOption("out")){
				m.setOutputFile(new File(cmd.getOptionValue("out")));
			}
			if(cmd.hasOption("ci")){
				m.enableCaseInsensitive(true);
			}
			if(cmd.hasOption("url")){
				m.setUrl(cmd.getOptionValue("url"));
			}
			else{
				System.err.println("Connection url not specified.  Exiting...");
				formatter.printHelp("kql", options);
			}
			if(cmd.hasOption("user")){
				m.setUser(cmd.getOptionValue("user"));
			}
			else{
				System.err.println("Connection user not specified.  Exiting...");
				formatter.printHelp("kql", options);
			}
			if(cmd.hasOption("password")){
				m.setPassword(cmd.getOptionValue("password"));
			}
			else{
				System.err.println("Connection password not specified.  Exiting...");
				formatter.printHelp("kql", options);
			}
			try{
				m.initiateConnection();
			}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println("Could not initialize connection");
				return;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("Could not parse options correctly:"+e.toString());
			formatter.printHelp( "kql", options );
			return;
		}
		try {
			CommandLine cmd = parser.parse( options, args);
			if(cmd.hasOption("kqlq")){
				executor.setPersistConnection(false);
				executor.setReturnResultObject(true);
				ResultSet rs = executor.executeQuery();
				
				rs.getStatement().close();
				rs.close();
			}
			else if(cmd.hasOption("ql")){
				executor.executeQueryList();
			}
			else{
				System.err.println("No input query");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	private void initiateConnection() throws MalformedURLException, SQLException {
		// TODO Auto-generated method stub
		this.executor.initializeConnection();
	}
	private void setUrl(String optionValue) {
		// TODO Auto-generated method stub
		this.executor.setUrl(optionValue);
	}
	private void setUser(String optionValue) {
		// TODO Auto-generated method stub
		this.executor.setUser(optionValue);
	}
	private void setPassword(String optionValue) {
		// TODO Auto-generated method stub
		this.executor.setPassword(optionValue);
	}
	private void enableCaseInsensitive(boolean b) {
		this.executor.enableCaseInsensitive(b);
	}
	public void enableDebug(boolean value){
		this.executor.enableDebug(value);
	}
	public void setQuery(String query){
		this.executor.setQuery(query);
	}
	public void setRowLimit(int limit){
		this.executor.setRowLimit(limit);
	}
	public void setOutputFile(File f){
		this.executor.setOutputfile(f);
	}
	public QueryExecutor instantiateExecutor() throws SQLException, MalformedURLException{
		this.executor = new QueryExecutor();
		return this.executor;
	}
}
