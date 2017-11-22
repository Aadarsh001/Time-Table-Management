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
@WebServlet(description = "a simple one", urlPatterns = { "/section_timetable" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class section_timetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		System.out.println("Hello Servlet");
		PrintWriter writer = response.getWriter();
		String section = request.getParameter("section");
	
		
		
	String[][] section_timetable = 	Section.getSection(section);
		
		
		
	writer.println("<html><head><style> .void{background: rgba(255, 255, 255, 0.1); } .void:focus {background : rgba(237, 242, 181,1)} ;  ::-webkit-input-placeholder{color: #8E8E8E;font-style:italic;}:focus::-webkit-input-placeholder{text-indent: -999px}::-moz-placeholder{color: #8E8E8E;font-style:italic;}:focus::-moz-placeholder{text-indent: -999px}</style><link rel=\"stylesheet\" href=\"mystyle.css\" > </head> <body> <div class=\"container teal borderYtoX\"><a href = \"admin.htm\">HOME</a><a href=\"showTeachers\">TEACHERS</a><a href=\"showSections\">SECTIONS</a><a>ABOUT</a><a>CONTACT</a></div><h1>Section Database</h1><table class=\"center\"> <tbody><tr> <th>Time</th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th></tr> ");
    
	writer.println("<form action='sectioninfo' method='post'>");	
	int a = 8;
	for (int i=0;i<10;i++){
			writer.println("<tr>");
		
			
            
			for(int j=0;j<6;j++){
				
				if(j==0){
					
					
					
					writer.println( "<td style=\"font-size : 15px;\">"+ a + ":00 - " + (a + 1) + ":00" +"</td>");
					
					a = a + 1;
					
					
					
				}
				
				else if(section_timetable[i][j]==null)
				{
					
					writer.println( "<td><input class = \"void\" type='text'  style = \"width: 100%; margin-bottom: 10px; border: none; outline: none; padding: 5px; font-size: 15px; color: #0c0202; text-shadow: 1px 1px 1px rgba(0,0,0,0.3); border: 1px solid rgba(0,0,0,0.3); border-radius: 4px; box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2); -webkit-transition: box-shadow .5s ease; -moz-transition: box-shadow .5s ease; -o-transition: box-shadow .5s ease; -ms-transition: box-shadow .5s ease; transition: box-shadow .5s ease; font-weight:bold;  font-color:black;  \"name='text[" + i + "][" + j + "]' " + "placeholder= \"Empty Slot\"> </td>");
				}
				
				else{
		
				writer.println( "<td><input type='text' style = \"width: 100%; margin-bottom: 10px; background:rgba(43, 80, 127, 0.94); border: none; outline: none; padding: 5px; color: #fff;  text-shadow: 1px 1px 1px rgba(0,0,0,0.3); border: 1px solid rgba(0,0,0,0.3); border-radius: 4px; box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2); -webkit-transition: box-shadow .5s ease; -moz-transition: box-shadow .5s ease; -o-transition: box-shadow .5s ease; -ms-transition: box-shadow .5s ease; font-weight:bold; font-size: 14px; transition: box-shadow .5s ease;    \"name='text[" + i + "][" + j + "]' " +  "value = '"+section_timetable[i][j]+"'></td>");
				
				}
			}
		}writer.println("</tr></table>");
		
		writer.println("<input type = hidden name = 'section' value =  \" "+ section +"\">");
		writer.println("<button style=\"box-shadow: rgb(35, 57, 94) 0px 0px 15px 3px inset; background: linear-gradient(rgb(46, 70, 110) 5%, rgb(65, 89, 137) 100%) rgb(46, 70, 110); border-radius: 17px; border: 1px solid rgb(31, 47, 71); display: inline-block; cursor: pointer; color: rgb(255, 255, 255); font-family: Arial; font-size: 15px; padding: 7px 41px; text-decoration: none; text-shadow: rgb(38, 54, 102) 0px 1px 0px;  display: block; margin-left: auto; margin-right: auto \" type=\"submit\" class=\"btn btn-primary btn-block btn-large\">Submit Class.</button>");
		writer.println("</form><br><br><br><br></body></html>");
		
		

		
	}
 }

	        //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
	   


