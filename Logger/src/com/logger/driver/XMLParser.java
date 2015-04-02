package com.logger.driver;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser{
	
	private String url;
	private String userName;
	private String table;
	private String password;
	private String pack;
	private String ui;
	
	public String getPassword() {
		return password;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public  void readFile(){
			
		File fXmlFile = new File("configuration.xml");
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize(); 		 
		NodeList nList = doc.getElementsByTagName("DATABASE");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			 
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				setUrl(eElement.getElementsByTagName("url").item(0).getTextContent());
				setUserName(eElement.getElementsByTagName("username").item(0).getTextContent());
				setTable(eElement.getElementsByTagName("table").item(0).getTextContent());
				setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
				setPack(eElement.getElementsByTagName("package").item(0).getTextContent());
				setUi(eElement.getElementsByTagName("MainUIClass").item(0).getTextContent());
			}
		}
		}catch(Exception e){
			
		}	 
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
