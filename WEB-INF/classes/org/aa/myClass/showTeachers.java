package org.aa.myClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servlet
 */
@WebServlet(description = "Creates A Teacher", urlPatterns = { "/showTeachers" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class showTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello Servlet");
		PrintWriter writer = response.getWriter();
		//String Name = request.getParameter("name");
		
		

		
		
		
		
		//Admin.CreateSection(Name);
		
		//response.sendRedirect("1.html");
		
		String a[][] =   Teacher.showTeachers();
  	  
    	int  b =  a.length;
    	
    	int j =0;
    	
    	System.out.println(b);
		
		System.out.println("Job Done");
		writer.println("<html> <head> <link rel=\"stylesheet\" href=\"mystyle.css\" > </head> <body> <div class=\"container teal borderYtoX\"><a href=\"admin.htm\">HOME</a><a href=\"showTeachers\">TEACHERS</a><a href=\"showSections\">SECTIONS</a><a>ABOUT</a><a>CONTACT</a></div><table style = \"margin-top:90px; margin-bottom:90px;\"class=\"center\"> <tbody><tr style= \"font-weight:bolder; padding:50px; font-size:17px;\"><th colspan=\"6\">Teacher Database</th></tr><tr style= \"font-weight:bolder; font-size:13px;\"> <th>Name</th> <th>Designation</th> <th>Department</th> <th>Email</th> <th>Contact No.</th></tr> ");
		
		for(j = 0 ; j<b;j++)
		{
			writer.println("<tr style = \"font-weight:bold;\">");
			writer.println("<td style = \"padding:20px 40px;\"><a href = \"teacher_timetable?teacher=" +a[j][0]  + "\">"  + a[j][0]+   "</td>");
			writer.println("<td style = \"padding:20px 40px;\">" + a[j][1] +  "</td>");
			writer.println("<td style = \"padding:20px 40px;\">" +a[j][2]+    "</td>");
			writer.println("<td style = \"padding:20px 40px;\">" + a[j][3] + "</td>");
			writer.println("<td style = \"padding:20px 40px;\">" +a[j][4]+   "</td>");
			writer.println("<td style = \"padding:20px 40px;\"><a href = \"delete_teacher?teacher=" +a[j][0]  + "\"><button class=\"close\">" + "Close" +"</button></td>");
			writer.println("</tr>");
			//<td><span class="myButton">null</span></td>
			
		}
		
		
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		String[] location = request.getParameterValues("location");
		String[] ResNotes;
			
	        String button = request.getParameter("button");

	        int i = button.charAt(7) -48;
	        int j = button.charAt(10) -49;
	        
	        int[ ] class1 = {1,2,3,4,5,6,7,8,9,10};
	        String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

            ResNotes=Admin.getResNotes("CS_2", day[j], class1[i]);
            writer.println("Resources: "+ResNotes[0]+"  Notes: "+ResNotes[1]);
	        } }

	        //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
	   


