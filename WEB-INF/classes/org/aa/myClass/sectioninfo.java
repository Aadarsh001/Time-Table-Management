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
@WebServlet(description = "a simple one", urlPatterns = { "/sectioninfo" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class sectioninfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		String Subject_Teacher =  request.getParameter("text[0][1]");
		
		System.out.println(Subject_Teacher);
		 
		
		String Sections = request.getParameter("section");
		
		System.out.println(Sections);
		
		String[] days = new String[5];
		
		days[0] = "Monday";
		days[1] = "Tuesday";
		days[2] =  "Wednesday";
		days[3] =  "Thursday";
		days[4] = "Friday"; 
						
		
		
		int i = 0;
		int j = 1;
		
		for(i = 0; i<10 ;i++)
		{
			
			for(j = 1 ; j<6 ; j++)
			{
				
				
				
				Subject_Teacher = request.getParameter("text[" + i + "][" + j +  "]");
				
				
				
				System.out.println("Subject is " + Subject_Teacher);
				
				
				
				//if(Subject=="")
					//continue;
				
				
				
				
				Section.setSchedule(days[j - 1] , i + 1 , Subject_Teacher , Sections);
				
				
				
			}
			
			
			
		}
		
		
	
		
		
		
		
		
		
		
 }
	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	PrintWriter writer = response.getWriter();
	
	String Subject_Teacher =  request.getParameter("text[0][1]");
	
	System.out.println(Subject_Teacher);
	 
	
	String Sections = request.getParameter("section");
	
	System.out.println(Sections);
	
	String[] days = new String[5];
	
	days[0] = "Monday";
	days[1] = "Tuesday";
	days[2] =  "Wednesday";
	days[3] =  "Thursday";
	days[4] = "Friday"; 
					
	
	
	int i = 0;
	int j = 1;
	
	for(i = 0; i<10 ;i++)
	{
		
		for(j = 1 ; j<6 ; j++)
		{
			
			
			
			Subject_Teacher = request.getParameter("text[" + i + "][" + j +  "]");
			
			
			
			System.out.println("Subject is " + Subject_Teacher);
			
			
			
			//if(Subject=="")
				//continue;
			
			
			
			
			Section.setSchedule(days[j - 1] , i + 1 , Subject_Teacher , Sections);
			
			
			
		}
		
		
		
	}
	
	

	
		
		
	
		
		
		
		
		
		
		
 }

}       //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
	   


