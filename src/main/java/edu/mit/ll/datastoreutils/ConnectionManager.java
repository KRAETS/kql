package edu.mit.ll.datastoreutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getDBConnection(String url, String user, String password) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public static ResultSet runQuery(String query, Connection con, boolean printout,QueryMapperManager man) throws SQLException {
		// TODO Auto-generated method stub
		man.setQuery(query);
		man.setConnection(con);
		man.setLogOutput(printout);
		return man.runQuery();
	//(new SqlToMongoMapper(query)).runQuery(con, b);
	}
}
