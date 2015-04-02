package com.logger.db;

import java.sql.Connection;

public class DbConnection {
	
	protected Connection con;
	protected String query;
	protected String table;
		
	public Connection getCon() {
		return con;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	
	
		
}
		
	

