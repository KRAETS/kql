package edu.mit.ll.datastoreutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getDBConnection(String url, String user, String password) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public static Connection getELKConnection(String url, String user,
			String password) {
		// TODO Auto-generated method stub
		ELKConnection elkCon = new ELKConnection(url,user,password);
		return null;
	}

	public static ResultSet runQuery(String query, Connection con, boolean b) throws SQLException {
		// TODO Auto-generated method stub
		if(con instanceof ELKConnection){
			return (new SqlToELKMapper(query)).runQuery(con,b);
		}
		else{
			return (new SqlToMongoMapper(query)).runQuery(con, b);
		}
	}

	

}
