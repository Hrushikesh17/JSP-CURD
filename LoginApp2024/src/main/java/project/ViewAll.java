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
@WebServlet("/view")
public class ViewAll extends HttpServlet{
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	    try {
	 			Class.forName("com.mysql.cj.jdbc.Driver");
	 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
	 			PreparedStatement ps=con.prepareStatement("select * from product");
	 			ResultSet rs=ps.executeQuery();
	 			resp.setContentType("text/html");
				PrintWriter pw=resp.getWriter();
				pw.print("   <table border={1.5}> <thead>\r\n"
						+ "	        	<tr>\r\n"
						+ "	        	    <th >Date</th>\r\n"
						+ "	             	<th >Description</th>\r\n"
						+ "	            	<th >Title</th>\r\n"
						+ "	            	<th >Status</th>\r\n"
						+ "	        	</tr>\r\n"
						+ "	        </thead>\r\n"
						+ "	        <tbody>");
	 			while(rs.next()) {
	 				pw.print("<tr>\r\n"
	 						+ "	<td>"+rs.getString(1)+"</td>\r\n"
	 						+ "	<td>"+rs.getString(2)+"</td>\r\n"
	 						+ "	<td>"+rs.getString(3)+"</td>\r\n"
	 						+ "	<td>"+rs.getString(4)+"</td>\r\n"
	 						+"</tr>");
	 			}
	 			pw.print("</tbody> </table>");

	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 }
}
