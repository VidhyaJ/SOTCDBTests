package roughwork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class getDomainsDbName {
	
		public static ResultSet rs1;
	    public static Connection conn=null;
	    
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			String driver="org.postgresql.Driver";
	        String userName = "postgres";
	        String password = "postgres";  
	        String hostnam="jdbc:postgresql://10.37.4.140:5432/accmgmtdb";
	        String account_id ="";
	        String url ="";
	          try{
	            Class.forName(driver).newInstance();// create object of Driver
	             conn=getConnection(hostnam,userName,password);    
	  

	            Statement stmt1 = conn.createStatement();
	          
	          
	          String query1="select account_id,url from tbl_accounts where flag=2 and activate=true and url='vidhyaraj12'";
	          rs1 = stmt1.executeQuery(query1);
	          while(rs1.next()){
	                 account_id = rs1.getString(1);
	                 url = rs1.getString(2);
	           }
	            closeconnection();
	            System.out.println(" url : "+url+"-------account id : " +account_id);	        
	                 
	          
	        }catch(Exception e){
	                e.printStackTrace();
	        }finally{
	            //closeconnection();
	        }    

	  }
	  
	  public static Connection getConnection(String hostname,String userName,String password) throws SQLException{        
	      System.out.println("Inside conenction");
	      conn = DriverManager.getConnection(hostname,userName,password);
	      return conn;
	      
	  }
	 public static void closeconnection() throws SQLException{
	     System.out.println("Inside Close");
	     conn.close();
	 }

	

}
/*
String hostname="jdbc:postgresql://10.37.4.140:5432/"+url;
conn=getConnection(hostname,userName,password);
 Statement stmt2 = conn.createStatement();
String query2 ="select asset_name from tbl_assets";
rs1 = stmt2.executeQuery(query2);
while(rs1.next()){
    String assetName = rs1.getString(1);
    
    System.out.println("Asset Name :"+assetName);
*/