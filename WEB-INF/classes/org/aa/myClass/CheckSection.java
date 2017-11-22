package org.aa.myClass;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aa.myClass.Admin;

/**
 * Servlet implementation class CheckSection
 */
@WebServlet(urlPatterns = { "/checkSection" })
public class CheckSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		String[] location = request.getParameterValues("location");
		String[] ResNotes;
		
			
	        String button = request.getParameter("button");
	        String[] parts = button.split("\\s");
	        writer.println(button);
	        int i = button.charAt(6) -48;
	        int j = button.charAt(7) -49;
	        
	        
	        int[ ] class1 = {1,2,3,4,5,6,7,8,9,10};
	        String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

            ResNotes=Admin.getResNotes(parts[1], day[j], class1[i]);
           writer.println("Resources: "+ResNotes[0]+"  Notes: "+ResNotes[1]);
           //response.sendRedirect("http://localhost:8080/cd");
	        } 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
