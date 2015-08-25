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

		public static void main(String[] args) throws SQLException {
			
			  //String url = "jdbc:postgresql://10.37.4.140:5432;";
			  //String dbName = "database=senthilrun";
			  String driver="org.postgresql.Driver";
			  String userName = "postgres"; 
			  String password = "postgres";  
			  String hostnam="jdbc:postgresql://10.37.4.140:5432/senthilrun";
			  try{
				  Class.forName(driver).newInstance();// create object of Driver
				  //System.out.println(url+dbName);
				  conn=getConnection(hostnam,userName,password);
				 
				  Path path = Paths.get(filename);
				  
	 		      if (Files.exists(path)) {
					  Files.delete(path);
					  System.out.println("Deleted");
				   
				  }

				  Statement stmt1 = conn.createStatement();
				 // String query1="select count(*) as totalassets from tbl_assets";
				  String query1="select playname from tbl_sharelink where playname<>''";
				  rs1 = stmt1.executeQuery(query1);
				  while(rs1.next()){
					  System.out.println("Hi");
						System.out.println(rs1.getString(1));
				  }
				  
				  /*while(rs1.next()){
					  count=String.valueOf(rs1.getInt("totalassets"));
					  System.out.println("Total assets in the domain is  : " +count);
					  writetofile(filename,count);
			  	   }*/
				  
			/*	  query1="Select count(*) as totalusers from users";
				  rs1 = stmt1.executeQuery(query1);
				  while(rs1.next()){
					  count=String.valueOf(rs1.getInt("totalusers"));
					  System.out.println("Total Users in the domain is  : " +count);
					  writetofile(filename,count);
				  }
				  Statement stmt2 = conn.createStatement();
				  ResultSet rs1 = stmt2.executeQuery("select * from users");
				  
				  while(rs1.next()){
						System.out.println(rs1.getString(1) + "-- "+rs1.getString(2)+" -- "+rs1.getString(3));
						count=rs1.getString(1)+"--"+rs1.getString(2);
						writetofile(filename,count);
						 
				  }	  
						  
					 
				*/     
					  System.out.println("*********************************");
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


			
			



