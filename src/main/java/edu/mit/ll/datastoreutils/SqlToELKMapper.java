package edu.mit.ll.datastoreutils;

import java.sql.Connection;
import java.sql.ResultSet;

public class SqlToELKMapper {
	private String query;	
	public SqlToELKMapper(String query){
		this.query = query;
	}
	public ResultSet runQuery(Connection con, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}
