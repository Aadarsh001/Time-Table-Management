package org.aa.myClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CodeHard
 */
public class Admin {
    
    
      static String url = "jdbc:hsqldb:hsql://localhost/";
      
      static Connection con;
      static Statement stmt;
      String u= "worked";
     //Admin(){System.out.println("u");}
      
      
      public static void main(String args[]) { 
    
      /*CreateTeacherDatabase();            //Create Teacher Database For Storing Teacher Name And Their Corresponding Passwords For Login Purposes
           //Create TeacherSubject Database Storing Teacher Name And The Subject That They Teach
      CreateTeacher("Teacher3" , "Password" , "COA" , "DBMS" , "OOP" , "DSA"); //Creates A Teacher Also Update Both TeacherDatabase And TeacherSubjectDatabase
                 //Create Section Database For  Keeping Track Of Sections And Their Name 
    */
     // CreateSection("CS_2");          //Creates A Section Also Updates The SectionDatabase
    
    //Admin.CheckUserPass("15UCS001");
    
    	  //String a[][] =   Teacher.showTeachers();
    	  
    	//int  b =  a.length;
    	
    	//System.out.println(b);
    	  StartSession();
      }
  static void StartSession(){
    	 CreateSectionDatabase(); 
    	  CreateTeacherInformationDatabase();
    	  CreateTeacherDatabase();   
       
       
      }
    
      
    static void CreateSectionDatabase(){
        
         String createString = "create table Section_Database " + 
				"(Name varchar(15) primary key)" ;
				
            
          
		
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
   		  

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		

        
    }  
      
      static void CreateTeacherInformationDatabase(){
        
         String createString = "create table TeacherInformation " + 
"(Name varchar(20) primary key , Designation varchar(16),  Department varchar(4), Email varchar(20),  ContactNo varchar(10))" ;
				
            
          
		
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
   		  

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		

        
    }  
      
      
      
      
       
      
      
      
      
      
   static void CreateSection(String batch_name){
        
        
        
        
              
            String toexecute = 	" insert into Section_Database " + "values ( '" + batch_name + "')";
            System.out.println(toexecute);

		
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
			
			stmt.executeUpdate(toexecute);
			
			
			stmt.close();
			con.close();
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	
            
        
        
            Section.addSection(batch_name);
        
        
    }  
      
      
    
    static void CreateTeacherDatabase(){

               String createString = "create table Teacher_Database" + 
				"(Name varchar(20) primary key , " +
				"Password varchar(15) , FOREIGN KEY (Name) REFERENCES TeacherInformation(Name) ON UPDATE  CASCADE  ON DELETE  CASCADE )";
            
          
		
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
                        
                        
   		  

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
                       
		}
		

}
    
    
    static void CreateTeacher(String Name , String Password , String Email , String Department , String Designation, String ContactNo){

               
            
                
           
            String toexecute1  = " insert into TeacherInformation " + "values ( '" + Name + "' ,'" + Designation + "' ,'" + Department +  "' ,'" + Email + "' ,'"+ ContactNo +"')";
            System.out.println(toexecute1);
            String toexecute = 	" insert into Teacher_Database " + "values ( '" + Name + "' ,'" + Password + "')";
            System.out.println(toexecute);

		
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
			
			stmt.executeUpdate(toexecute1);
			stmt.executeUpdate(toexecute);
                       
			
			
			stmt.close();
			con.close();
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	
            
           Teacher.addTeacher(Name);
             
             
                     
        }
    
    
    
    static void delete_teacher(String Teacher_Name){

        
        
        
        
    String toexecute = "delete from teacherinformation where name = '" + Teacher_Name + "'";
    String toexecute1 = "drop table " + Teacher_Name;

	
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
		
	 
		stmt.executeUpdate(toexecute);
		stmt.executeUpdate(toexecute1);
                   
		
		
		stmt.close();
		con.close();
	} 
	catch(SQLException ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}

        
       
         
                 
    }

    
    
    
    
    static void delete_Section(String section_Name){

        
        
        
        
    String toexecute = "delete from section_database where name = '" + section_Name + "'";
    String toexecute1 = "drop table " + section_Name;
    String toexecute2 = "drop table " + section_Name + "_notes";
    String toexecute3 = "drop table " + section_Name + "_resources";

	
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
		
	 
		stmt.executeUpdate(toexecute);
		stmt.executeUpdate(toexecute1);
		stmt.executeUpdate(toexecute2);
		stmt.executeUpdate(toexecute3);
                   
		
		
		stmt.close();
		con.close();
	} 
	catch(SQLException ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}

        
       
         
                 
    }
    
    
    
    static int CheckUserPass(String userName , String passw){
    	
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
    		System.err.println("SQLException: " + ex.getMessage());return 0;
    	}
    	finally {
    			try{
    				
    				 String query1 = "select * from teacher_database" ;
    				 ResultSet rs1 = stmt.executeQuery(query1);
    				  while(rs1.next()){    
    					String name = rs1.getString("name"); 
    					System.out.println(name + "    "+userName);
    					
    				   if (name.equals(userName)){
    					   
    					   String pass = rs1.getString("password");
    					   
    					   if(pass.equals(passw)){
    						   System.out.println("Login Successful");
    						   //printservlet("Login Successful");
    						   return 10;
    					   }
    					   
    				   }
    				   
    				   }
    				
    			
    			
    			   
    			}catch(SQLException e){return 0;}
    		}
        
         return 0;
        
    }
    
static int CheckUserPass(String userName){
	String[] parts = userName.split("(?=U)");
	
	String part1 = parts[0]; // 004
	String[] part = parts[1].split("(?<=S)");
	String part2 = part[0];
	String part3  = part[1];
	System.out.println(part1+"_"+part2+"_"+part3);
	int rollNo=Integer.parseInt(part3);  
	
	
	
	
	if(part2.equals("UCS") && rollNo<100 ){
		return 1;
	}
	
	
	if(part2.equals("UCS") && rollNo>100 ){
	if(rollNo<173){
		return 2;
	}
	else{
		return 0;}
	}	
	
	
	if(part2.equals("UCC") && rollNo<=46 ){
		
		return 3;
	}	
	

	if(part2.equals("UEC") && rollNo<=78 ){
		
		return 4;
	}
	
	
	if(part2.equals("UME") && rollNo<=42 ){
		
			return 5;
		}

	
	if(part2.equals("UMM") && rollNo<=10 ){
		
		return 6;
	}
	
		
	
return 0;}
    
static String[][] getTimeTable(String tbName){
    	//System.out.println("Reached function");
    	String[][] timeTable = new String[10][6];
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
		//System.out.println("Reached finally");
			try{
				int SNO=-1;
				//System.out.println("Reached try");
				 String query1 = "select * from "+ tbName ;
				 
				 ResultSet rs1 = stmt.executeQuery(query1);
				 
				  while(rs1.next()){
					  SNO++;
					timeTable[SNO][0] = rs1.getString("class"); 
					timeTable[SNO][1] = rs1.getString("Monday"); 
					timeTable[SNO][2] = rs1.getString("Tuesday"); 
					timeTable[SNO][3] = rs1.getString("Wednesday"); 
					timeTable[SNO][4] = rs1.getString("Thursday"); 
					timeTable[SNO][5] = rs1.getString("Friday"); 
				  }
				  System.out.println(timeTable[0][2]);
			   
			}catch(SQLException e){
				
				System.err.println("SQLException: " + e.getMessage());
			}
		}
    
     return timeTable;
    
}
 


static String[] getResNotes(String Section, String day, int class1){
	//System.out.println("Reached function");
	String[] ResNotes = new String[2];
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
	//System.out.println("Reached finally");
		try{
	
			//System.out.println("Reached try");
			 String query1 = "select "+day+" from  "+Section +"_Resources where class = "+class1  ;
			 String query = "select "+day+" from  "+Section +"_Notes where class = "+class1  ;
			 ResultSet rs1 = stmt.executeQuery(query1);
			 ResultSet rs = stmt.executeQuery(query);
			 
			  while(rs1.next() && rs.next()){
				  
				ResNotes[0] = rs1.getString(day); 
				ResNotes[1] = rs.getString(day); 
				
			  }
			  //System.out.println(ResNotes[0][1]);
		   
		}catch(SQLException e){}
	}

 return ResNotes;

}
    
    
    
    
    
    
    

}


