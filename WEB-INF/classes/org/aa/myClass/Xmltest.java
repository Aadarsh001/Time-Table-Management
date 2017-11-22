package org.aa.myClass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "a simple one", urlPatterns = { "/xmPath" })
public class Xmltest extends HttpServlet {
	private static final long serialVersionUID = 2L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello xmlServlet");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>hello in xmlservlet</h3>");
	}

}
