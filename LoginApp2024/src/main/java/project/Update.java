package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class Update extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String id = req.getParameter("id"); 
	   String price=req.getParameter("price");
	    try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
			PreparedStatement ps=con.prepareStatement("update product set price = ? where id=?");
			ps.setString(1,price);
			ps.setString(2,id);
		    ps.executeUpdate();	
//			resp.setContentType("text/html");
//			PrintWriter pw=resp.getWriter();
//			pw.print("product"+id+"Remove from cart");
			resp.sendRedirect("Home.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
