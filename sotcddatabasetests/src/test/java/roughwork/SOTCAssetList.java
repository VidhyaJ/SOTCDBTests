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


public class SOTCAssetList {
	

		public static ResultSet rs1;
		public static Connection conn=null;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			  String driver="org.postgresql.Driver";
			  String userName = "postgres"; 
			  String password = "postgres";  
			  String hostnam="jdbc:postgresql://10.37.4.140:5432/arjunsg";
			  String assetIds ="";
			  String assetInfo ="";
			  String showName ="";
			  try{
				  Class.forName(driver).newInstance();// create object of Driver

				  conn=getConnection(hostnam,userName,password);	 
				  PreparedStatement prep=conn.prepareStatement("select asset_name from tbl_assets where to_char(assets_id,'999') like ?");
				  prep.setString(1, "select regexp_split_to_table(assetdata, ',') as asset from tbl_sharelink where share_id=17");
				 // prep.setInt(1,82);
				   ResultSet rs1=prep.executeQuery();
				  System.out.println(rs1.next());
				  while(rs1.next()){
					  System.out.println("Hellp");
					   		  showName = rs1.getString(1);
					   		System.out.println("Show Name : "+showName);
				 }
				  

				/*  String query1="select assetdata,playname from tbl_sharelink where share_id=17";
				  rs1 = stmt1.executeQuery(query1);
				  while(rs1.next()){
					   assetIds = rs1.getString(1);
					   showName = rs1.getString(2);
				 }
				  System.out.println("Show Name : "+showName);*/
				 // String getAssetNameSql ="select asset_name from tbl_assets where assets_id in "+ "("+assetIds+")";
				  //String getAssetNameSql ="select asset_name from tbl_assets where assets_id in (select regexp_split_to_array(assetdata, ',') from tbl_sharelink where share_id=17)";
				 // rs1 = stmt2.executeQuery(getAssetNameSql);
				  /*while(rs1.next()){
					  String assetName = rs1.getString(1);
					  
					  System.out.println("Asset Name :"+assetName);
				 }
				*/
				  /*
				   * PreparedStatement prep=conn.prepareStatement("Select * from users where name =? And sex=?");	
prep.setString(1,'B'); At the location of the first ? Introduce B.	
prep.setString(2,'F'); At the location of the first ? Introduce B.	
Resultset rs1=prep.executeQuery();	

				   */
				   
				  
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
	


