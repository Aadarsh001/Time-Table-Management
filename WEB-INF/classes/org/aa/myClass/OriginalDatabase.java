package org.aa.myClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OriginalDatabase {
	String url = "jdbc:hsqldb:hsql://localhost/";
	String createString;
	
	static Connection con;
	static Statement stmt;
	
	
	
void Create(){
		
		createString = "create table OriginalDatabase"  + 
				"(SNO int primary key , Section char(6) , day varchar(8), " +
				"class1 int, pv varchar(140))";
		String createString1 = "create table NoRU"  + 
				"(SNO int)";
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
   		    stmt.executeUpdate(createString1);

			stmt.close();
			con.close();
   		    
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		
	}

void reset(){

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
				 while(SNO!=0){
				  String query = "select " + "Section,day,class1,pv from OriginalDatabase where SNO = " + SNO;
				 ResultSet rs = stmt.executeQuery(query);
				 
			  // String s ="HE";
			    while(rs.next()){                
			    	String section = rs.getString("Section");
			    	String day = rs.getString("day");
			    	int class1 = rs.getInt("class1");
			    	String pv = rs.getString("pv");
			    	
			    	//System.out.println("hello");
			    						
			    		//System.out.println("h2");
			    		
			    			stmt.executeUpdate(" update " + section + " Set " + day + " = " + pv + " where class = " + class1);
			    			stmt.executeUpdate(" delete from OriginalDatabase where SNO = " + SNO);
			    			stmt.executeUpdate(" update NoRU  Set SNO = SNO -1");
			    					SNO--;}}
			    stmt.close();
					    			con.close();}
			    			
			    		 
			    		catch(SQLException ex) {
			    			System.err.println("SQLException: " + ex.getMessage());
			    		}
			    		
			    	
			    	
			    	
					}
			    
			}
			

}


