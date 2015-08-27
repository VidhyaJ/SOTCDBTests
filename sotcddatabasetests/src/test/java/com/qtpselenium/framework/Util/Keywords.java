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
	public static ResultSet rs3=null;
	public static Statement stmt1=null;
	public static Statement stmt2=null;
	public static Connection conn;
	public static String assetIds=null;
	
		
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
		
		
		//System.out.println("In ExecuteKeywords : " +testName);
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, 0, rNum);
			if(tcid.equalsIgnoreCase(testName)){
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, 2, rNum);
				//String object = xls.getCellData(Constants.KEYWORDS_SHEET, 3, rNum);
				String dataCol = xls.getCellData(Constants.KEYWORDS_SHEET, 4, rNum);
			//	System.out.println(keyword +" --- "+object+" --- "+dataCol);
									
				switch (keyword) {
				case "getActiveShowsCount":
					  getActiveShowsCount(data.get("query"));
					  break;
				case "getActiveShowsNames":
					  getActiveShowsNames(data.get("query"));
					  break;
				case "getRecordCount":
					  getRecordCount(data.get("query"));
					  break;
				case "OpendbConnection":
					OpendbConnection(data.get("username"),data.get("password"),data.get("ipaddress"),data.get("driver"),data.get("database"));
					break;
				case "closedbConnection":
					closedbConnection();
					break;
				case "getAssetsinShow":
					  getAssetsinShow(data.get("showname"));
				default:
					break;
				}		
			}
		}			
	}

	public void getAssetsinShow(String show) throws SQLException {
	
		   log("Starting getAssetsinShow " +show);
		   		   
		   stmt1 = conn.createStatement();
		   stmt2 = conn.createStatement();
		  
		  String query1="select assetdata,playname from tbl_sharelink where playname like "+"'"+show+"'";
		  
		  rs1 = stmt1.executeQuery(query1);
          while(rs1.next()){
               assetIds = rs1.getString(1);
               String showName = rs1.getString(2);
               System.out.println("Show Name : "+showName);
         }
          
   
          String getAssetNameSql ="select asset_name from tbl_assets where assets_id in "+ "("+assetIds+")";
          rs1 = stmt2.executeQuery(getAssetNameSql);
          int i=1;
          while(rs1.next()){
        	  
              String assetName = rs1.getString(1);
              log("Asset Name :"+i+"---"+assetName);
              i++;
         }
		  log("Ending getAssets in show " +show);
	}

	public void getActiveShowsNames(String query) throws SQLException {
		
		log("Starting getActiveShowsNames");
		log(query);		
	    stmt1 = conn.createStatement();
    	rs1 = stmt1.executeQuery(query);
    	int i=1;
        while(rs1.next()){
	    //System.out.println("Shownames : " +rs1.getString(1));
        log("Showname  " +i+": " +rs1.getString(1));
        i++;
        }
        log(" Ending getActiveShowsNames");
	
	
		// TODO Auto-generated method stub
		
		
	}

	public void closedbConnection() throws SQLException {
		
		log("Start Closing Connection");
		   	conn.close();
		log("Connection closed successfully");
		    }


	public void OpendbConnection(String uname,String passwd,String ip,String dr,String db) throws SQLException {
		// TODO Auto-generated method stub
			
			log("Starting OpenDbConnection");
			String driver=dr;
			String userName = uname;
			String password = passwd;  
			String hostname="jdbc:postgresql://"+ip+"/"+db;
			try{
			  Class.forName(driver).newInstance();// create object of Driver
			  conn = DriverManager.getConnection(hostname,userName,password);
			  log("Connection to database is Successful");
			}catch(Exception e){
				e.printStackTrace();
				log("Connection Failure.Please check");
			}
		}
	
	public void getRecordCount(String query) throws SQLException {
   		        
		log("Starting getRecordCount function");
		log(query);		
	    stmt1 = conn.createStatement();
    	rs1 = stmt1.executeQuery(query);
	    
		  	  while(rs1.next()){
			  log("Total Records in table is  : " +rs1.getInt(1));
	  	   }
		  	log("Ending getRecordCount function");
		
	}

	public void getActiveShowsCount(String query) throws SQLException {
		log("Starting getActiveShowsCount function");
		log(query);		
	    stmt1 = conn.createStatement();
    	rs1 = stmt1.executeQuery(query);
        while(rs1.next()){
        log("Total Records in table is  : " +rs1.getString(1));
       
        }
        log("Ending getActiveShowsCount function");
	}
	
	public void setLogger(Logger log){
		Application_Log = log;
	}
		
	public static void log(String message)
	{
		
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