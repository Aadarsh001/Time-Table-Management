package org.aa.myClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
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
@WebServlet(description = "a simple one", urlPatterns = { "/servletPath" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")}
)
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello Servlet");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("u");
		String passw = request.getParameter("p");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		String tbName=null;
		
		if (userName!="" && userName!=null){
			session.setAttribute("savedUserName",userName);
			context.setAttribute("savedUserName",userName);
		}
		
				
		//writer.println("hello "+userName+ "session: " + (String) session.getAttribute("savedUserName") + "context: "+ (String) context.getAttribute("savedUserName"));
		/*writer.println("<h3>hello "+userName+" in servlet</h3>");
		writer.println("default: "+ this.getServletConfig().getInitParameter("defaultUser"));
		*/
		String[][] tt = new String[10][6];
		int x =0;
		writer.println(passw);
			
		if(passw != null && !passw.isEmpty()) {
			if(userName.equals("admin") && passw.equals("root"))
				response.sendRedirect("admin.htm");
			else
			x = Admin.CheckUserPass(userName, passw);//writer.println(x+1);	
		}
		else{
		    x = Admin.CheckUserPass(userName);writer.println(x);}
		
		writer.println(x+2);
		if (x==1){ tbName="CS_1";}
		if (x==2){tbName="CS_2";}
		if (x==3){tbName="CCE";}
		if (x==4){tbName="ECE";}
		if (x==5){tbName="MCH";}
		if (x==6){tbName="MCT";}
		if (x==10){tbName=userName;}
		tt=Admin.getTimeTable(tbName);
		request.setAttribute("batcName",tbName);
		if(x!=0){
		writer.println("<!DOCTYPE html> <html> <head> <style> @import 'https://fonts.googleapis.com/css?family=Raleway';html, body{margin: 0px;}header, footer{font-family: Raleway;margin: 0 auto;padding: 2em 3em;text-align: center;background: #555;}header h1{color: #AAA;font-size: 40px;font-weight: lighter;margin-bottom: 5px;}header span{color: #222;}footer span{color: #AAA;}div.container{font-family: Raleway;margin: 0 auto;padding: 2em 3em;text-align: center;}div.container a{color: #FFF;text-decoration: none;font: 20px Raleway;margin: 0px 10px;padding: 10px 10px;position: relative;z-index: 0;cursor: pointer;}.red{background: #f44336;}.purple{background: #673ab7;}.indigo{background: #3f51b5;}.blue{background: #2196f3;}.cyan{background: #00bcd4;}.teal{background: #009688;}.green{background: #4caf50;}.lightGreen{background: #8bc34a;}.lime{background: #c0ca33;}.yellow{background: #fdd835;}.amber{background: #ffc107;}.orange{background: #ff9800}.deepOrange{background: #ff5722;}.brown{background: #795548;}.gray{background: #9e9e9e;}/* Top and Bottom borders go out */div.topBotomBordersOut a:before, div.topBotomBordersOut a:after{position: absolute;left: 0px;width: 100%;height: 2px;background: #FFF;opacity: 0;transition: all 0.3s;}div.topBotomBordersOut a:before{top: 0px;transform: translateY(10px);}div.topBotomBordersOut a:after{bottom: 0px;transform: translateY(-10px);}div.topBotomBordersOut a:hover:before, div.topBotomBordersOut a:hover:after{opacity: 1;transform: translateY(0px);}/* Top and Bottom borders come in */div.topBotomBordersIn a:before, div.topBotomBordersIn a:after{position: absolute;left: 0px;width: 100%;height: 2px;background: #FFF;opacity: 0;transition: all 0.3s;}div.topBotomBordersIn a:before{top: 0px;transform: translateY(-10px);}div.topBotomBordersIn a:after{bottom: 0px;transform: translateY(10px);}div.topBotomBordersIn a:hover:before, div.topBotomBordersIn a:hover:after{opacity: 1;transform: translateY(0px);}/* Top border go down and Left border appears */div.topLeftBorders a:before{position: absolute;top: 0px;left: 0px;width: 2px;height: 0px;background: #FFF;opacity: 1;transition: all 0.3s;}div.topLeftBorders a:after{position: absolute;top: 0px;left: 0px;width: 100%;height: 2px;background: #FFF;opacity: 1;transition: all 0.3s;}div.topLeftBorders a:hover:before{height: 100%;}div.topLeftBorders a:hover:after{opacity: 0;top: 100%;}/* Circle behind */div.circleBehind a:before, div.circleBehind a:after{position: absolute;top: 22px;left: 50%;width: 50px;height: 50px;border: 4px solid #0277bd;transform: translateX(-50%) translateY(-50%) scale(0.8);border-radius: 50%;background: transparent;opacity: 0;transition: all 0.3s;z-index: -1;}div.circleBehind a:after{border-width: 2px;transition: all 0.4s;}div.circleBehind a:hover:before{opacity: 1;transform: translateX(-50%) translateY(-50%) scale(1);}div.circleBehind a:hover:after{opacity: 1;transform: translateX(-50%) translateY(-50%) scale(1.3);}/* Brackets go out */div.brackets a:before, div.brackets a:after{position: absolute;opacity: 0;font-size: 35px;top: 0px;transition: all 0.3s;}div.brackets a:before{content: '(';left: 0px;transform: translateX(10px);}div.brackets a:after{content: ')';right: 0px;transform: translateX(-10px);}div.brackets a:hover:before, div.brackets a:hover:after{opacity: 1;transform: translateX(0px);}/* Border from Y to X  */div.borderYtoX a:before, div.borderYtoX a:after{position: absolute;opacity: 0.5;height: 100%;width: 2px;content: '';background: #FFF;transition: all 0.3s;}div.borderYtoX a:before{left: 0px;top: 0px;}div.borderYtoX a:after{right: 0px;bottom: 0px;}div.borderYtoX a:hover:before, div.borderYtoX a:hover:after{opacity: 1;height: 2px;width: 100%;}/* Border X get width  */div.borderXwidth a:before, div.borderXwidth a:after{position: absolute;opacity: 0;width: 0%;height: 2px;content: '';background: #FFF;transition: all 0.3s;}div.borderXwidth a:before{left: 0px;top: 0px;}div.borderXwidth a:after{right: 0px;bottom: 0px;}div.borderXwidth a:hover:before, div.borderXwidth a:hover:after{opacity: 1;width: 100%;}/* Pull down  */div.pullDown a:before{position: absolute;width: 100%;height: 2px;left: 0px;top: 0px;content: '';background: #FFF;opacity: 0.3;transition: all 0.3s;}div.pullDown a:hover:before{height: 100%;}/* Pull up  */div.pullUp a:before{position: absolute;width: 100%;height: 2px;left: 0px;bottom: 0px;content: '';background: #FFF;opacity: 0.3;transition: all 0.3s;}div.pullUp a:hover:before{height: 100%;}/* Pull right  */div.pullRight a:before{position: absolute;width: 2px;height: 100%;left: 0px;top: 0px;content: '';background: #FFF;opacity: 0.3;transition: all 0.3s;}div.pullRight a:hover:before{width: 100%;}/* Pull left  */div.pullLeft a:before{position: absolute;width: 2px;height: 100%;right: 0px;top: 0px;content: '';background: #FFF;opacity: 0.3;transition: all 0.3s;}div.pullLeft a:hover:before{width: 100%;}/* Pull up and down  */div.pullUpDown a:before, div.pullUpDown a:after{position: absolute;width: 100%;height: 2px;left: 0px;content: '';background: #FFF;opacity: 0.3;transition: all 0.3s;}div.pullUpDown a:before{top: 0px;}div.pullUpDown a:after{bottom: 0px;}div.pullUpDown a:hover:before, div.pullUpDown a:hover:after{height: 100%;}/* Pull right and left  */div.pullRightLeft a:before, div.pullRightLeft a:after{position: absolute;width: 2px;height: 100%;top: 0px;content: '';background: #FFF;opacity: 0.3;transition: all 0.3s;}div.pullRightLeft a:before{left: 0px;}div.pullRightLeft a:after{right: 0px;}div.pullRightLeft a:hover:before, div.pullRightLeft a:hover:after{width: 100%;}/* Highlight text out  */div.highlightTextOut a{color: rgba(255, 255, 255, 0.3);}div.highlightTextOut a:before, div.highlightTextIn a:before{position: absolute;color: #FFF;top: 0px;left: 0px;padding: 10px;overflow: hidden;content: attr(alt);transition: all 0.3s;transform: scale(0.8);opacity: 0;}div.highlightTextOut a:hover:before, div.highlightTextIn a:hover:before{transform: scale(1);opacity: 1;}/* Highlight text in  */div.highlightTextIn a{color: rgba(0, 0, 0, 0.4);}div.highlightTextIn a:before{transform: scale(1.2);} table a:link { color: #666; font-weight: bold; text-decoration:none; } table a:visited { color: #999999; font-weight:bold; text-decoration:none; } table a:active, table a:hover { color: #bd5a35; text-decoration:underline; } table { font-family:Arial, Helvetica, sans-serif; color:#666; font-size:12px; text-shadow: 1px 1px 0px #fff; background:#eaebec; margin:20px; border:#ccc 1px solid; -moz-border-radius:3px; -webkit-border-radius:3px; border-radius:3px; -moz-box-shadow: 0 1px 2px #d1d1d1; -webkit-box-shadow: 0 1px 2px #d1d1d1; box-shadow: 0 1px 2px #d1d1d1; } table th { padding:21px 25px 22px 25px; border-top:1px solid #fafafa; border-bottom:1px solid #e0e0e0; background: #ededed; background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb)); background: -moz-linear-gradient(top, #ededed, #ebebeb); } table th:first-child { text-align: left; padding-left:20px; } table tr:first-child th:first-child { -moz-border-radius-topleft:3px; -webkit-border-top-left-radius:3px; border-top-left-radius:3px; } table tr:first-child th:last-child { -moz-border-radius-topright:3px; -webkit-border-top-right-radius:3px; border-top-right-radius:3px; } table tr { text-align: center; padding-left:20px; } table td:first-child { text-align: left; padding-left:20px; border-left: 0; } table td { padding:18px; border-top: 1px solid #ffffff; border-bottom:1px solid #e0e0e0; border-left: 1px solid #e0e0e0; background: #fafafa; background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa)); background: -moz-linear-gradient(top, #fbfbfb, #fafafa); } table tr.even td { background: #f6f6f6; background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6)); background: -moz-linear-gradient(top, #f8f8f8, #f6f6f6); } table tr:last-child td { border-bottom:0; } table tr:last-child td:first-child { -moz-border-radius-bottomleft:3px; -webkit-border-bottom-left-radius:3px; border-bottom-left-radius:3px; } table tr:last-child td:last-child { -moz-border-radius-bottomright:3px; -webkit-border-bottom-right-radius:3px; border-bottom-right-radius:3px; } table tr:hover td { background: #f2f2f2; background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0)); background: -moz-linear-gradient(top, #f2f2f2, #f0f0f0); } </style> </head> <body> <div class=\"container teal borderYtoX\"><a>HOME</a><a>ARTICLES</a><a>PORTFOLIO</a><a>ABOUT</a><a>CONTACT</a></div><table> <tr> <th>Class</th> <th>Monday</th> <th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th>");
		if(x==10){
			writer.println("<form action='AddResNotes' method='get'>");
		}
		else{
		writer.println("<form action='checkSection' method='get'>");}	
		for (int i=0;i<10;i++){
				writer.println("</tr><tr>");
			

				for(int j=0;j<6;j++){
					
					if(j==0){
						
						
						writer.println( "<td>"+tt[i][j]+"</td>");
						
						
					}
					//writer.println("<script>var  </script>")
					else{
					int k = i*(5) + j;
					writer.println( "<td><button type='submit' name='button' value='button"+i+j+" "+tbName+" "+tt[i][j]+"'>"+tt[i][j]+"</button></td>");
					}
				}
			}writer.println("</tr></table></form></body></html>");
		}
			
			//writer.println(" <tr> <td>"+tt[0][0]+"</td> <td>Maria Anders</td> <td>Germany</td> </tr> <tr> <td>Centro comercial Moctezuma</td> <td>Francisco Chang</td> <td>Mexico</td> </tr> <tr> <td>Ernst Handel</td> <td>Roland Mendel</td> <td>Austria</td> </tr> <tr> <td>Island Trading</td> <td>Helen Bennett</td> <td>UK</td> </tr> <tr> <td>Laughing Bacchus Winecellars</td> <td>Yoshi Tannamuri</td> <td>Canada</td> </tr> <tr> <td>Magazzini Alimentari Riuniti</td> <td>Giovanni Rovelli</td> <td>Italy</td> </tr> </table> </body> </html> ");
		
			
			//writer.println(" <tr> <td>"+tt[0][0]+"</td> <td>Maria Anders</td> <td>Germany</td> </tr> <tr> <td>Centro comercial Moctezuma</td> <td>Francisco Chang</td> <td>Mexico</td> </tr> <tr> <td>Ernst Handel</td> <td>Roland Mendel</td> <td>Austria</td> </tr> <tr> <td>Island Trading</td> <td>Helen Bennett</td> <td>UK</td> </tr> <tr> <td>Laughing Bacchus Winecellars</td> <td>Yoshi Tannamuri</td> <td>Canada</td> </tr> <tr> <td>Magazzini Alimentari Riuniti</td> <td>Giovanni Rovelli</td> <td>Italy</td> </tr> </table> </body> </html> ");
		else{writer.println("Login Unsuccessful");}//response.sendRedirect("1.html");}
		
		//RequestDispatcher rd = request.getRequestDispatcher("checkSection");
		//rd.forward(request,response);
		
	}
		
}

	       
	   


