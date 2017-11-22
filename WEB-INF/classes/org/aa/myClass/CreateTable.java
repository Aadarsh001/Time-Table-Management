package org.aa.myClass;
import java.sql.*;
//import java.util.Arrays;




public class CreateTable{
static Connection con;
static Statement stmt;

	public static void main(String args[]) {                                                                                                                                                                                
      
	
		
		String url = "jdbc:hsqldb:hsql://localhost/";
	
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
					String query = "select * from rat where Monday!='NULL'";
					ResultSet rs = stmt.executeQuery(query);
					
					//System.out.println("Days ");
					while(rs.next()){
					String s =rs.getString("Monday");
					int f = rs.getInt("Class");
					
				    //student_a1[f] = 0;
					
					//System.out.println(rs);
					//System.out.println(s+" "+f);
				}
					
					//System.out.println(Arrays.toString(student_a1));
					
					stmt.close();
					con.close();
				}catch(SQLException e){}
			}
				
	}
}


