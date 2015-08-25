package com.qtpselenium.framework.Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
//import org.apache.http.client.fluent.Request;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Keywords {
	static Logger Application_Log;
	static Properties prop;
	//WebDriver driver;
	static String value;
	static Keywords k;
	public static String count;
	public static ResultSet rs1=null;
	public static Statement stmt1=null;
	public static Connection conn;
	
	public Keywords(){
			// initialize properties file
		prop=new Properties();
		try {
			FileInputStream fs = new FileInputStream(Constants.PROPERTIES_FILE_PATH);
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	public void executeKeywords(String testName, Xls_Reader xls,
			Hashtable<String, String> data) throws Exception {
		
		
		System.out.println("In ExecuteKeywords : " +testName);
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, 0, rNum);
			if(tcid.equalsIgnoreCase(testName)){
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, 2, rNum);
				String object = xls.getCellData(Constants.KEYWORDS_SHEET, 3, rNum);
				String dataCol = xls.getCellData(Constants.KEYWORDS_SHEET, 4, rNum);
				System.out.println(keyword +" --- "+object+" --- "+dataCol);
							
				switch (keyword) {
				case "getShows":
					getShows(data.get("query"));
					break;
				case "getAssets":
					getAssets(data.get("query"));
					break;
				case "OpendbConnection":
					OpendbConnection(data.get("username"),data.get("password"),data.get("ipaddress"),data.get("driver"),data.get("database"));
					break;
				case "closedbConnection":
					closedbConnection();
					break;
					
				default:
					break;
				}		
			}
		}			
	}

	public void closedbConnection() throws SQLException {
		System.out.println("Close Connection");
		log("Closing Connection");
		   	conn.close();
		   	log("Connection closed successfully");
		    }


	public void OpendbConnection(String uname,String passwd,String ip,String dr,String db) throws SQLException {
		// TODO Auto-generated method stub
			System.out.println("Open connection");
			String driver=dr;
			String userName = uname;
			String password = passwd;  
			String hostname="jdbc:postgresql://"+ip+"/"+db;
			try{
			  Class.forName(driver).newInstance();// create object of Driver
			  conn = DriverManager.getConnection(hostname,userName,password);
			  log("Connection Successful");
			}catch(Exception e){
				e.printStackTrace();
				log("Connection Failure");
			}
		}
	
	public void getAssets(String query) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(query);
				log(query);		
			   stmt1 = conn.createStatement();
		    	rs1 = stmt1.executeQuery(query);
	    
		  	  while(rs1.next()){
			  //count=String.valueOf(rs1.getInt(1));
			  System.out.println("Total Records in table is  : " +rs1.getInt(1));
			  log("Total Records in table is  : " +rs1.getInt(1));
			  rs1=null;
			  stmt1=null;
			  
			  //writetofile(filename,count);
	  	   }
		
	}

	public void getShows(String query) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(" In getShows");
		
		System.out.println(query);
		log(query);		
	   stmt1 = conn.createStatement();
    	rs1 = stmt1.executeQuery(query);

  	  while(rs1.next()){
	  //count=String.valueOf(rs1.getInt(1));
	  System.out.println("Records are : " +rs1.getString(1));
	  log("Total Records in table is  : " +rs1.getString(1));
	  rs1=null;
	  stmt1=null;
	}
	}
	
	public void setLogger(Logger log){
		Application_Log = log;
	}
		
	public static void log(String message)
	{
		System.out.println(message);
		Application_Log.debug(message);
	}
	
	public static Keywords getInstance() {
		if(k==null){
			System.out.println("Existing Instance");
			k = new Keywords();
		}
		return k;
	}

	
}