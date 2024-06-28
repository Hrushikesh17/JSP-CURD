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

@WebServlet("/regi")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //fetching data from request
		String name=req.getParameter("username");
		String email=req.getParameter("usermail");
		String phone=req.getParameter("userphone");
		String address=req.getParameter("useradd");
		String dob=req.getParameter("userdob");
		String password=req.getParameter("userpass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setString(5, dob);
			ps.setString(6, password);
            //Execute the query
			ps.executeUpdate();
			//request goes to login page
			resp.sendRedirect("Login.html");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
