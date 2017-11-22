package org.aa.myClass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddResNotes
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddResNotes" })
public class AddResNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String Resources = request.getParameter("Resources");
		String Notes = request.getParameter("Notes");
		HttpSession session = request.getSession(true);
		
		 String button = request.getParameter("button");
	        session.setAttribute("savedButton",button);
	        
	        String[] parts = button.split("\\s");
	        String Section;
	        String[] part = parts[2].split("(?<=_)");
	        Section= part[0];
	        //writer.println(button);
	        String button1=(String)session.getAttribute("savedButton"); 
	        writer.println(button1);
	        int i = button1.charAt(6) -48;
	        int j = button1.charAt(7) -49;
	        //button.substring(12)
	        writer.println("html code");
	        String[ ] class1 = {"1","2","3","4","5","6","7","8","9","10"};
	        String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
	        Teacher.addResources(day[j] , class1[i] , Resources, Section);
	        Teacher.addNotes(day[j] , class1[i] , Notes, Section);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
