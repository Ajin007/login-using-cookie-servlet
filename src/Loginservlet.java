import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loginservlet extends HttpServlet  {
	
	public void doPost(HttpServletRequest Req,HttpServletResponse Res) throws IOException,ServletException{
		
		Res.setContentType("text/html");
		PrintWriter out=Res.getWriter();
		
		Req.getRequestDispatcher("link.html").include(Req, Res);
		
		String name=Req.getParameter("UN");
		String password=Req.getParameter("PW");
		
		if(password.equals("admin")){
			out.print("you have succesfully logged in");
			out.print("<br>welcome"+name);
			
			//this is to add the sessions 
			// either we shall use the cookie tag or else the session tag for the same , cooke tag is available in the below provided line
			// remove the session if need ot work on the session
			HttpSession session=Req.getSession();
			session.setAttribute("name", name);
			
			//this is to add the cookie for continuos accessing
			Cookie cw=new Cookie("name", name);
			Res.addCookie(cw);
		}
		else {
			out.print("Sorry! user name and the password does not match");
			Req.getRequestDispatcher("login.html").include(Req,Res);
		}
		out.close();
	}

}
