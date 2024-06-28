package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logi")
public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
		PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{   
			//Creating Session object for the user
			HttpSession session=req.getSession();
			//stroing information into session
			session.setAttribute("myemail", email);
			
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.print("welcome.."+email);
			
			RequestDispatcher rd =req.getRequestDispatcher("Home.html");
			rd.include(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.print("ICORRECT EMAIL ID OR PASSWORD");
			
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

}