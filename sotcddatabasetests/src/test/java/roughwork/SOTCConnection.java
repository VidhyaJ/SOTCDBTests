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

	public class SOTCConnection {
		
		public static String count;
		public static ResultSet rs1;
		public static Connection conn=null;
		public static String filename="C:\\Users\\Vidhya\\Sample\\temp.txt";
		public static String showName;
		public static String assetIds;

		public static void main(String[] args) throws SQLException {
			String ShowName="Buffalo Photos";
			
			  //String url = "jdbc:postgresql://10.37.4.140:5432;";
			  //String dbName = "database=senthilrun";
			  String driver="org.postgresql.Driver";
			  String userName = "postgres"; 
			  String password = "postgres";  
			  String hostnam="jdbc:postgresql://10.37.4.140:5432/vidhya";
			  try{
				  Class.forName(driver).newInstance();// create object of Driver
				  //System.out.println(url+dbName);
				  conn=getConnection(hostnam,userName,password);
				  //String query1="select assetdata,playname from tbl_sharelink where playname like "+"'"+ShowName+"'";
				  
				  Statement stmt1 = conn.createStatement();
	              Statement stmt2 = conn.createStatement();
	              String query1="select assetdata,playname from tbl_sharelink where playname like "+"'"+ShowName+"'";
	             // String query1="select assetdata,playname from tbl_sharelink where playname='Buffalo Photos'";
	              rs1 = stmt1.executeQuery(query1);
	              while(rs1.next()){
	                   assetIds = rs1.getString(1);
	                   showName = rs1.getString(2);
	             }
	              System.out.println("Show Name : "+showName);
	              String getAssetNameSql ="select asset_name from tbl_assets where assets_id in "+ "("+assetIds+")";
	              rs1 = stmt2.executeQuery(getAssetNameSql);
	              while(rs1.next()){
	                  String assetName = rs1.getString(1);
	                  
	                  System.out.println("Asset Name :"+assetName);
	             }
	            
	          }catch(Exception e){
	                  e.printStackTrace();
	          }finally{
	              closeconnection();
	          }  
				  
				 
			}
		
		public static Connection getConnection(String hostname,String userName,String password) throws SQLException{
			 // conn = DriverManager.getConnection(url+dbName,userName,password);
			  /*//conn=DriverManager.getConnection("jdbc:sqlserver://54.86.36.165;database=dbcotccotcdev", "sa",
	                "TdevpCen@!l17");*/
			System.out.println("Inside conenction");
			conn = DriverManager.getConnection(hostname,userName,password);
			return conn;
			
		}
	    public static void closeconnection() throws SQLException{
	    	System.out.println("Inside Close");
	    	conn.close();
	    }
	    
	    public static void writetofile(String fileName, String outputtext) throws IOException{
	    	
	    	File f = new File(filename);
	    	if(!f.exists()){
	    		f.createNewFile();
	    		}
	    		 // writing
				  FileWriter w = new FileWriter(fileName,true);
				  BufferedWriter out = new BufferedWriter(w);
				  out.write("Total Records in  : " +outputtext);
				  out.newLine();
				  out.flush();
	    	
	    	    }
	    	
	    }


			
			



