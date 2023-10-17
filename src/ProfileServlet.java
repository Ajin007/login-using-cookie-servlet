import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {  
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	                          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        request.getRequestDispatcher("link.html").include(request, response);
	        
	        
	        Cookie ck[]=request.getCookies();
	        if(ck!=null){
	        	String name=ck[0].getValue();
	        	if (!name.equals("")||name!=null){
	        		out.print("<b>Welcome to the profile</b>");
	        		out.print("<br>welcome"+name);
	        	}
	        }else {
	        	out.print("please login firsr");
	        	request.getRequestDispatcher("login.html").include(request,response);
	        }
	        
	        out.close();

}
}
