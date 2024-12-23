package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resetPassword")
public class Password extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");

		PrintWriter out = resp.getWriter();
		 if (!password.equals(confirmPassword)) {
			 
	            out.print("Passwords do not match. Please try again.");
	            return; 
	        }
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

			PreparedStatement ps = c.prepareStatement("update registers set pass =?  where email =?");
			ps.setString(1, password);
			ps.setString(2, email);

			ps.executeUpdate();
			
			out.print("Data Updated Successfully......");
			System.out.println("Data is Updated Succesfully......");

			
			resp.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.include(req, resp);
			
		} catch (Exception e) {
			
		}

		
		
		
	
	}
	
	
}
