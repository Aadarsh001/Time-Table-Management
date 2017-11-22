package org.aa.myClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Teacher {
		
	static String url = "jdbc:hsqldb:hsql://localhost/";
	static String createString;
	
	static Connection con;
	static Statement stmt;
		
	String name;
	
	Teacher(String a){
		
		name  = a;
		
	
		
		
	}
	
  static String[][] showTeachers(){
    	//System.out.println("Reached function");
    	
		String[][] teacher_database = null;
		
		
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
				
				 String query1 = "select count(*) as row_number from teacherinformation";
				 System.out.println("Reachesdsd try");
				 ResultSet rs_count = stmt.executeQuery(query1);
				 
				 System.out.println("Reached try");
				 rs_count.next();
				 
				 int x = rs_count.getInt("row_number");
				 System.out.println("asas");
				 System.out.println(x);
				 System.out.println("asas");
				 
				teacher_database = new String[x][5];
				
				query1 = "select * from teacherinformation";
				rs_count = stmt.executeQuery(query1);
				//System.out.println("hello");
				int SNO = 0;
				 while(rs_count.next()){
					  
					teacher_database[SNO][0] = rs_count.getString("name"); 
					teacher_database[SNO][1] = rs_count.getString("Designation");
					teacher_database[SNO][2] = rs_count.getString("Department"); 
					teacher_database[SNO][3] = rs_count.getString("Email"); 
					teacher_database[SNO][4] = rs_count.getString("ContactNo"); 
					
					SNO++;
					
				  }
				  //System.out.println(teacher_database[2][0]);
			   
			}catch(SQLException e){
				
				System.err.println("SQLException: " + e.getMessage());
			}
		}
	
	
	return teacher_database;
}
    
   
    
  static void addNotes(String day_name , String class1 , String Notes , String Section)
  {
	try{
		Class.forName("org.hsqldb.jdbcDriver");
	}
	catch(java.lang.ClassNotFoundException e) {
		System.err.print("ClassNotFoundException: ");
		System.err.println(e.getMessage());
	}
		try{
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			
			
		//	stmt.executeUpdate("insert into " + batch_name + "_resources"   + " values( 1 , null, null, null, null, null)");
			stmt.executeUpdate(" update " + Section + "_Notes" + " Set " + day_name + " = " + "'" + Notes  + "'"+ " where class = " + class1);				    			

			
			stmt.close();
			con.close();
		} 
		
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		
	}
	
  
 static void addResources(String day_name , String class1 , String Resources, String Section)
  {
          
          
            try{
		Class.forName("org.hsqldb.jdbcDriver");
	}
	catch(java.lang.ClassNotFoundException e) {
		System.err.print("ClassNotFoundException: ");
		System.err.println(e.getMessage());
	}
	
		try{
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			
			
		//	stmt.executeUpdate("insert into " + batch_name + "_resources"   + " values( 1 , null, null, null, null, null)");
			stmt.executeUpdate(" update " + Section + "_Resources" + " Set " + day_name + " = " + "'" + Resources  + "'"+ " where class = " + class1);				    			

			
			stmt.close();
			con.close();
		} 
		
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		
	}



	
 public static void updateSchedule(String day_name , String class1 , String Subject , String Section , String tName)
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
					int SNO=0;
				 String query1 = "select SNO from NoRU" ;
				 ResultSet rs1 = stmt.executeQuery(query1);
				  while(rs1.next()){                
				    	SNO = rs1.getInt("SNO");}
					 
					 String query = "select " + day_name + " from " + Section + " where Class = " + class1 ;
					 //System.out.println(query);
					 ResultSet rs = stmt.executeQuery(query);
					 
				
				  // String s ="HE";
				    while(rs.next()){                
				    	String s = rs.getString(day_name);
				    	//System.out.println("hello");
				    	if(s==null)
				    	{			
                                          
                                          
				    		System.out.println("h2");
				    		try{
				    			con = DriverManager.getConnection(url, "sa", "");
				    			stmt = con.createStatement();
				    			String Subject_Section = "'"+ Subject + "_" + Section + "'";
				    			stmt.executeUpdate(" update " + tName + " Set " + day_name + " = " + Subject_Section + " where class = " + class1);
				    			//stmt.executeUpdate(" update " + Section + " Set " + day_name + " = " + "'" + Subject  + "'"+ " where class = " + class1);				    			
				    			
				    			System.out.println(SNO);
				    			stmt.executeUpdate("insert into " + "OriginalDatabase" +" values("+ SNO +",'"+Section +"','"+day_name+"',"+class1+",'"+s+"')");
				    			stmt.executeUpdate("Update noru set sno=sno+1");
				    			stmt.close();
				    			con.close();
				    		} 
				    		catch(SQLException ex) {
				    			System.err.println("SQLException: " + ex.getMessage());
				    		}
				    		
				    	}
				    	
				    	else
				    	{
				    		System.out.println("The Slot is Already Occupied By " + s + "Please Choose Another One");
				    	}
					   
					System.out.println(s);
					
				    }
				}catch(SQLException e){}
			}
				
	}
		
		
	
	
	
	
	

	static void setSchedule(String day_name , int class1 , String Subject_Section , String teacher_name)
	{

		
		System.out.println("I am here");

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
					 
					
					
		                        String Section = null;  		
		                        String Subject = null;
				    	        System.out.println("I AM HERE" + Subject_Section);          
                                
				    	        if(Subject_Section!= "")
				    	        	
					            {
				    	        	String[] parts = Subject_Section.split("_");
					                Section = parts[1];
					                Subject = parts[0];
					            }
				    			con = DriverManager.getConnection(url, "sa", "");
				    			stmt = con.createStatement();
				    			String Subject_Teacher=  Subject + "_" + teacher_name;
                                
				    			
				    			
				    			//stmt.executeUpdate(" update " + Teacher + " Set " + day_name + " = " + Subject_Section + " where class = " + class1);
				 String query_teacher = " update " + teacher_name + " Set " + day_name + " = " + "'" + Subject_Section  + "'"+ " where class = " + class1 ;
				    String query_subject = " update " + Section + " Set " + day_name + " = " + "'" + Subject_Teacher  + "'"+ " where class = " + class1 ;
				    					
				    			
				                System.out.println(query_teacher);
				    			stmt.executeUpdate(query_teacher);
				    			
				    			if(Subject_Section!="")
				    			    stmt.executeUpdate(query_subject);
				    			
				    			stmt.close();
				    			con.close();
				    		} 
				    		catch(SQLException ex) {
				    			System.err.println("SQLException: " + ex.getMessage());
				    		}
				    		
				    
				    	
				    	
					
				    }
				
			}
	
	 static void addTeacher(String name)
	  
	{
		try{
			Class.forName("org.hsqldb.jdbcDriver");
		}
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		
	createString = "create table " + name +
				"(Class int primary key , Monday varchar(4) , " +
				"Tuesday char(4), " +
				"Wednesday char(4), " +
				"Thursday char(4), " +
				"Friday char(4))";
		
		
		
		
		try {
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
   		    stmt.executeUpdate(createString);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	
		createDatabase(name);
		
		//A6.addNotes()
		
	}
	
	  void addNotes(String day_name , String class1 , String Notes , String Subject , String Section)
	  {
		try{
			Class.forName("org.hsqldb.jdbcDriver");
		}
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
			try{
				con = DriverManager.getConnection(url, "sa", "");
				stmt = con.createStatement();
				
				
			//	stmt.executeUpdate("insert into " + batch_name + "_resources"   + " values( 1 , null, null, null, null, null)");
    			stmt.executeUpdate(" update " + Section + "_Notes" + " Set " + day_name + " = " + "'" + Notes  + "'"+ " where class = " + class1);				    			

				
				stmt.close();
				con.close();
			} 
			
			catch(SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
			
			
		}
		
	  
	  void addResources(String day_name , String class1 , String Resources, String Subject , String Section)
	  {
              
              
                try{
			Class.forName("org.hsqldb.jdbcDriver");
		}
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
			try{
				con = DriverManager.getConnection(url, "sa", "");
				stmt = con.createStatement();
				
				
			//	stmt.executeUpdate("insert into " + batch_name + "_resources"   + " values( 1 , null, null, null, null, null)");
    			stmt.executeUpdate(" update " + Section + "_Resources" + " Set " + day_name + " = " + "'" + Resources  + "'"+ " where class = " + class1);				    			

				
				stmt.close();
				con.close();
			} 
			
			catch(SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
private static  void createDatabase(String name){
		
		 
		
		try{
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			
			
			stmt.executeUpdate("insert into " + name  + " values( 1 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 2 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 3 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 4 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 5 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 6 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 7 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 8 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 9 , null, null, null, null, null)");
			stmt.executeUpdate("insert into " + name  + " values( 10 , null, null, null, null, null)");
			
			stmt.close();
			con.close();
		} 
		
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		
	}
	


  static String[][] getTeacher(String teacher_name){
    	//System.out.println("Reached function");
    	
		String[][] getTeacher = null;
		
		
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
				
				 
				 
				getTeacher = new String[10][6];
				
				String query = "select * from " + teacher_name ;
				ResultSet rs_count  = stmt.executeQuery(query);
				int SNO = 0;
				
				System.out.println("joker" );
				
				 while(rs_count.next()){
					  
					 getTeacher[SNO][0]= rs_count.getString("Class"); 
					 getTeacher[SNO][1]= rs_count.getString("Monday"); 
					 getTeacher[SNO][2]= rs_count.getString("Tuesday"); 
					 getTeacher[SNO][3]= rs_count.getString("Wednesday"); 
					 getTeacher[SNO][4]= rs_count.getString("Thursday");
					 getTeacher[SNO][5]= rs_count.getString("Friday"); 
					 

					 
					 
					
					
					SNO++;
					
				  }
				  //System.out.println(teacher_database[2][0]);
			   
			}catch(SQLException e){
				
				System.err.println("SQLException: " + e.getMessage());
			}
		}
	
	
	return getTeacher;
}
	
		
		
		
	}

