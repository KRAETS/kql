package edu.mit.ll.datastoreutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryMapperManager {
	protected String query;
	protected Connection connection;
	protected boolean printout;
	
	public void setQuery(String query) {
		// TODO Auto-generated method stub
		this.query = query;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.connection = con;
	}

	public abstract ResultSet runQuery() throws SQLException;
	
	public void setLogOutput(boolean printout) {
		// TODO Auto-generated method stub
		
	}

}
