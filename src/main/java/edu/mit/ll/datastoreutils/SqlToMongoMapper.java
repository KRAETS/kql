package edu.mit.ll.datastoreutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mongodb.jdbc.MongoStatement;

public class SqlToMongoMapper extends QueryMapperManager{
	
	private boolean debug = false;
	public SqlToMongoMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public SqlToMongoMapper(String sqlExpression) {
		this.query = sqlExpression;
	}
	
	/**
	 * Helper method to run SQL query on MongoDB.
	 * 
	 * @param con Connection object to MongoDB
	 * @param sql SQL statement to run
	 * 
	 * @throws SQLException
	 *             if a database error occurs
	 */
	public ResultSet doQuery(Connection con, String sql, boolean printOut) throws SQLException
	{
		Statement stmt = con.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);
		stmt.setFetchSize(0);

		System.out.println("\n\nExecuting query:      " + sql);
		ResultSet rst = stmt.executeQuery(sql);

//		System.out.println("Executed Mongo query: " + ((MongoStatement) stmt).getQueryString());
		System.out.println("Query execution complete.\n");
		System.out.println("Results:\n");


		if(printOut||debug){
			int count = Utils.printResults(rst);
			System.out.println("\nTotal results: " + count);
		}
		// Close statement
		//        rst.close();
		//        stmt.close();

		return rst;
	}


	public void enableDebug(boolean debug) {
		// TODO Auto-generated method stub
		this.debug = debug;
	}
	@Override
	public ResultSet runQuery() throws SQLException {
		// TODO Auto-generated method stub
		if(query==null||connection==null){
			return null;
		}
		else
		{
			Statement stmt = connection.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);
			stmt.setFetchSize(0);

			System.out.println("\n\nExecuting query:      " + query);
			ResultSet rst = stmt.executeQuery(query);
//			if(printout){
//				System.out.println("Executed Mongo query: " + ((MongoStatement) stmt).getQueryString());
//				System.out.println("Query execution complete.\n");
//				System.out.println("Results:\n");
//			}

			if(printout||debug){
				int count = Utils.printResults(rst);
				System.out.println("\nTotal results: " + count);
			}
			// Close statement
			//        rst.close();
			//        stmt.close();

			return rst;

		}
	}
	public ResultSet runQuery(Connection con, boolean printOut) throws SQLException{
		return runQuery(query, con, printOut);
	}
	public ResultSet runQuery(String sql, Connection con, boolean printOut) throws SQLException{

		// Create a statement and submit a query.
		/*
		 * Sample queries
		 */
		return doQuery(con, sql, printOut);

	}


}
