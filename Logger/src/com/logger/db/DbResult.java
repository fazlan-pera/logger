package com.logger.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.logger.driver.XMLParser;

public class DbResult extends DbConnection{
	private ResultSet res;

	public DbResult(){
			XMLParser parser = new XMLParser();
			parser.readFile();
			this.table = parser.getTable(); 
	}
	public ResultSet getRes() {
		return res;
	}

	public void setRes(ResultSet res) {
		this.res = res;
	}
	
	public void executeMatchQuery(){
		try {
			XMLParser parser = new XMLParser();
			parser.readFile();
			String url = parser.getUrl();
			String userName = parser.getUserName();	
			String password = parser.getPassword();
			this.table = parser.getTable();
			this.con = DriverManager.getConnection(url,userName,password);
			Statement stmt = (Statement)con.createStatement();
			this.res = stmt.executeQuery(query);	
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
}
