package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addproduct")
public class AddToCartServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String price=req.getParameter("price");
        String qty=req.getParameter("qty");
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, qty);
            //Execute the query
			ps.executeUpdate();
//			request goes to Home page
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.print("product"+name+"Added to your cart");
			resp.sendRedirect("Home.html");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}
