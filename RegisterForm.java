package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegForm")

public class RegisterForm extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Fname = req.getParameter("name1");
		String lname = req.getParameter("name2");
		String email = req.getParameter("email1");
		String password = req.getParameter("pass1");
		String DateOfBirth = req.getParameter("dob");
		String Age = req.getParameter("age");
		String MobNu = req.getParameter("num");
		String Gender = req.getParameter("gender");
		String Address =req.getParameter("add");
		String City = req.getParameter("city");
		String State = req.getParameter("state");
		String Country = req.getParameter("con");
		String Degree = req.getParameter("deg");
		String PassYear = req.getParameter("passing");
		
		PrintWriter out = resp.getWriter();
		out.print("Data Inserted Successfully......");
		resp.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Data Inserted Successfully!');");
		out.println("window.location.href = 'successPage.html';"); 
		out.println("</script>");
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

			PreparedStatement ps = c.prepareStatement("insert into registers(fname, lname, email, pass, dob,age, mobno, gender,address,  city,state, coun,  degree, passyear ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, Fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, DateOfBirth);
			ps.setString(6, Age);
			ps.setString(7, MobNu);
			ps.setString(8, Gender);
			ps.setString(9, Address);
			ps.setString(10, City);
			ps.setString(11, State);
			ps.setString(12, Country);
			ps.setString(13, Degree);
			ps.setString(14, PassYear); 
			
			System.out.println("Data Inserted Successfully.....");
			ps.executeUpdate();

			
			c.close();

		} catch (Exception e) {
			 e.printStackTrace(); 

		}
		
		
	}
	

}
