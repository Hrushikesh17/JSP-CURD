package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session =req.getSession();
    	session.invalidate();
    	resp.setContentType("text/html");
    	PrintWriter pw =resp.getWriter();
    	pw.print("You have logout Successfully..");
    	RequestDispatcher rs = req.getRequestDispatcher("Login.html");
    	rs.include(req, resp);
    	
      }
}
