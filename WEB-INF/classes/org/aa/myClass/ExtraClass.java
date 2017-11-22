package org.aa.myClass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExtraClass
 */
@WebServlet("/ExtraClass")
public class ExtraClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtraClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		 String button = request.getParameter("button");
	        out.println(button);
	        //String class1 ="preety CS_1 1 2";
			String[] parts = button.split("\\s");
	        System.out.println(parts[0]+"  "+parts[1]+"  "+parts[2]+"  "+parts[3]+"  "+parts[4]);

	    Teacher.updateSchedule(parts[0] , parts[1] , parts[2], parts[3] , parts[4]);
	    response.sendRedirect("http://localhost:8080/servletPath");
        //out.println("Resources: "+ResNotes[0]+"  Notes: "+ResNotes[1]);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
