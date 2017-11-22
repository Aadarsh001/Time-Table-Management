

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
@WebServlet("/myservlet")
public class Button extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String button = request.getParameter("button");

       /* if ("button1".equals(button)) {
          System.out.println("Button1");
        } else if ("button2".equals(button)) {
        	System.out.println("Button2");
        } else if ("button3".equals(button)) {
        	System.out.println("Button2");
        } else {
            // ???
        }*/

        //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }

}