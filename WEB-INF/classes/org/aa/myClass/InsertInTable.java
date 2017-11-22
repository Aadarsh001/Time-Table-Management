package org.aa.myClass;


/*public class InsertCS_1 {

}*/
import java.sql.*;

public class InsertInTable{

	public static void main(String args[]) {

		String url = "jdbc:hsqldb:hsql://localhost/";
		Connection con;
		Statement stmt;
		
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
			
			stmt.executeUpdate("insert into CS_2 " + "values(1,'DBMS', 'OOP', 'DAA', 'COA' ,'ECO')");
			stmt.executeUpdate("insert into CS_2 " + "values(2,null, null, null,null, null)");
			stmt.executeUpdate("insert into CS_2 " + "values(3,'OOP','DAA' ,'COA' ,'ECO' ,'DBMS' )");
			stmt.executeUpdate("insert into CS_2 " + "values(4,null, null, null, null, null )");
			stmt.executeUpdate("insert into CS_2 " + "values(5,'DAA','COA'  ,'ECO' ,'DBMS' ,'OOP' )");
			stmt.executeUpdate("insert into CS_2 " + "values(6,null, null, null, null ,null)");
			stmt.executeUpdate("insert into CS_2 " + "values(7,null, null, null,null, null )");
			stmt.executeUpdate("insert into CS_2 " + "values(8,null,null ,null ,null ,null )");
			stmt.executeUpdate("insert into CS_2 " + "values(9,null, null, null, null, null )");
			stmt.executeUpdate("insert into CS_2 " + "values(10,null, null ,null ,null ,null )");
			
			stmt.close();
			con.close();
		} 
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}


