package com.logger.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.logger.driver.XMLParser;

public class DbUpdate extends DbConnection {
	
	public DbUpdate(){
		XMLParser parser = new XMLParser();
		parser.readFile();
		this.table = parser.getTable(); 
	}
	
	public void executeUpdateQuery(){
		XMLParser parser = new XMLParser();
		parser.readFile();
		String url = parser.getUrl();
		String userName = parser.getUserName();	
		String password = parser.getPassword();	
		try {
			this.con = DriverManager.getConnection(url,userName,password);
			Statement stmt = (Statement)con.createStatement();
			stmt.executeUpdate(query);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
