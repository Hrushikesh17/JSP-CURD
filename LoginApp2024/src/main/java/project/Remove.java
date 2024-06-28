package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/remove")
public class Remove extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
		PreparedStatement ps=con.prepareStatement("delete from product where id=?");
		ps.setString(1,id);
	    ps.executeUpdate();	
//		resp.setContentType("text/html");
//		PrintWriter pw=resp.getWriter();
//		pw.print("product"+id+"Remove from cart");
		resp.sendRedirect("Home.html");

	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
