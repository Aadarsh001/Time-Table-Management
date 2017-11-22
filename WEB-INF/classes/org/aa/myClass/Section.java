package org.aa.myClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Section {

	
	
	

	static String url = "jdbc:hsqldb:hsql://localhost/";
	//static String createString;
	//static String createString2;
	//static String createString3;
	
	static Connection con;
	static Statement stmt;
	
	String batch_name;
	
	Section(String a){
		
		batch_name  = a;
		
	}
	
	

	static void addSection(String batch_name)
	  
	{
            
            
                 String createString3 = "create table " + batch_name  + 
				"(Class int primary key , Monday varchar(4) , " +
				"Tuesday varchar(4), " +
				"Wednesday varchar(4), " +
				"Thursday varchar(4), " +
				"Friday varchar(4))";
            
            
            
		
		String createString = "create table " + batch_name  + "_notes"+
				"(Class int primary key , Monday varchar(140) , " +
				"Tuesday varchar(140), " +
				"Wednesday varchar(140), " +
				"Thursday varchar(140), " +
				"Friday varchar(140))";
		
		
		
		
		String createString2 = "create table " + batch_name + "_resources" +
				"(Class int primary key , Monday varchar(140) , " +
				"Tuesday varchar(140), " +
				"Wednesday varchar(140), " +
				"Thursday varchar(140), " +
				"Friday varchar(140))";
		try {
			Class.forName("org.hsqldb.jdbcDriver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		
		try {
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
   		    stmt.executeUpdate(createString);
   		    stmt.executeUpdate(createString2);
   		    stmt.executeUpdate(createString3);

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		
		createNotesandResourcesDatabase(batch_name);
		
	}
	
	
	

	
	
	
private static void createNotesandResourcesDatabase(String batch_name){
		
		 
		
		try{
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			
			
			stmt.executeUpdate("insert into " + batch_name + "_resources"   + " values( 1 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 2 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources"  + " values( 3 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 4 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources"  + " values( 5 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 6 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 7 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 8 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 9 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_resources" + " values( 10 , null, null, null, null, null)");
			
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 1 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 2 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 3 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 4 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 5 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 6 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 7 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 8 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 9 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name + "_notes" + " values( 10 , null, null, null, null, null)");
			
			
			stmt.executeUpdate("insert into " + batch_name +  " values( 1 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 2 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 3 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 4 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 5 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 6 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 7 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 8 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 9 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + batch_name +  " values( 10 , null, null, null, null, null)");
			
			
			
			stmt.close();
			con.close();
		} 
		
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		
	}
	
	
	static void setSchedule(String day_name , int class1 , String Subject_Teacher , String batch_name)
	{


		try {
			Class.forName("org.hsqldb.jdbcDriver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
   		    //stmt.executeUpdate(createString);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
				try{
					 
					 //String query = "select " + day_name + " from " + Section + " where Class = " + class1;
                                       //  String queries = "select " + day_name + " from " + Teacher + " where Class = " + class1 ;
                                         
                                         
                                         
                                         
                                         
                                      String Subject = null;
                                      String Teacher = null;
                                         
					 //System.out.println(query);
					// ResultSet rs = stmt.executeQuery(queries);
					 
				
				  // String s ="HE";
					

	    	        if(Subject_Teacher!= "")
	    	        	
		            {
	    	        	String[] parts = Subject_Teacher.split("_");
		                Teacher = parts[1];
		                Subject = parts[0];
		            }
					
				   String Subject_Section = Subject + "_" + batch_name;
				    	                  
                                            
				    		
				    			con = DriverManager.getConnection(url, "sa", "");
				    			stmt = con.createStatement();
				    			//String Subject_Section = "'"+ Subject + "_" + batch_name + "'";
                                                
				    			//stmt.executeUpdate(" update " + Teacher + " Set " + day_name + " = " + Subject_Section + " where class = " + class1);
				    			String query_Section = " update " + batch_name + " Set " + day_name + " = " + "'" + Subject_Teacher  + "'"+ " where class = " + class1 ;
				    			
				    			String query_Teacher = " update " + Teacher + " Set " + day_name + " = " + "'" + Subject_Section  + "'"+ " where class = " + class1 ;
				    			
				    			
				    			System.out.println(query_Section);
				    			
				    			
				    			System.out.println(query_Teacher);
				    			
				    			
				    			if(Subject_Teacher!="")
				    			    stmt.executeUpdate(query_Teacher);
				    			
				    			
				    			
				    			
				    			stmt.executeUpdate(query_Section);	
				    			stmt.close();
				    			con.close();
				    		} 
				    		catch(SQLException ex) {
				    			System.err.println("SQLException: " + ex.getMessage());
				    		}
				    		
				    
				    	
				    	
					
				    }
				
			}
				
	
	
	
	
	  static String[] showSections(){
	    	//System.out.println("Reached function");
	    	
			String[] sections_database = null;
			
			
	    try {
			Class.forName("org.hsqldb.jdbcDriver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			    //stmt.executeUpdate(createString);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
			System.out.println("Reached finally");
				try{
					
					System.out.println("Reached try");
					
					 String query1 = "select count(*) as row_number from section_database";
					 System.out.println("Reachesdsd try");
					 ResultSet rs_count = stmt.executeQuery(query1);
					 
					 System.out.println("Reached try");
					 rs_count.next();
					 
					 int x = rs_count.getInt("row_number");
					 System.out.println("asas");
					 System.out.println(x);
					 System.out.println("asas");
					 
					 sections_database = new String[x];
					
					query1 = "select * from section_database";
					rs_count = stmt.executeQuery(query1);
					System.out.println("heldddlo");
					int SNO = 0;
					
					//System.out.println("joker" );
					
					 while(rs_count.next()){
						  
						 sections_database[SNO]= rs_count.getString("name"); 
						 

						 
						 System.out.println("abra"  + sections_database[SNO]);
						
						
						SNO++;
						
					  }
					  //System.out.println(teacher_database[2][0]);
				   
				}catch(SQLException e){
					
					System.err.println("SQLException: " + e.getMessage());
				}
			}
		
		
		return sections_database;
	}
	    
	   
	    
	  static String[][] getSection(String section_name){
	    	//System.out.println("Reached function");
	    	
			String[][] getSection = null;
			
			
	    try {
			Class.forName("org.hsqldb.jdbcDriver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			    //stmt.executeUpdate(createString);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
			System.out.println("Reached finally");
				try{
					
					System.out.println("Reached try");
					
					 
					 
					 getSection = new String[10][6];
					
					String query = "select * from " + section_name ;
					ResultSet rs_count  = stmt.executeQuery(query);
					int SNO = 0;
					
					System.out.println("joker" );
					
					 while(rs_count.next()){
						  
						 getSection[SNO][0]= rs_count.getString("Class"); 
						 getSection[SNO][1]= rs_count.getString("Monday"); 
						 getSection[SNO][2]= rs_count.getString("Tuesday"); 
						 getSection[SNO][3]= rs_count.getString("Wednesday"); 
						 getSection[SNO][4]= rs_count.getString("Thursday");
						 getSection[SNO][5]= rs_count.getString("Friday"); 
						 

						 
						 
						
						
						SNO++;
						
					  }
					  //System.out.println(teacher_database[2][0]);
				   
				}catch(SQLException e){
					
					System.err.println("SQLException: " + e.getMessage());
				}
			}
		
		
		return getSection;
	}
		
	
	
}
