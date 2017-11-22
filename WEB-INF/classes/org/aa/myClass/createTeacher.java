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
@WebServlet(description = "Creates A Teacher", urlPatterns = { "/createTeacher" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class createTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello Servlet");
		//PrintWriter writer = response.getWriter();
		String Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		String Department = request.getParameter("Department");
		String Designation = request.getParameter("Designation");
		String ContactNo = request.getParameter("ContactNo.");

		
		
		System.out.println("Teacher Name Is : "  + Name);
		
		Admin.CreateTeacher(Name, Password, Email, Department, Designation, ContactNo);
		
		response.sendRedirect("admin.htm");
		
		
		System.out.println("Job Done");
		
		
		
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
	   


