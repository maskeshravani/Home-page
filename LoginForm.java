package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logform")
public class LoginForm extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

			PreparedStatement ps = c.prepareStatement("select * from registers where email = ? and pass = ?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html");
				out.print("<script type=\"text/javascript\">");
				out.print("alert('Data Login Successfully!');");
				out.print("window.location.href = 'successPage.html';");
				out.print("</script>");

				req.setAttribute("fname", rs.getString(1));
				req.setAttribute("lname", rs.getString(2));
				req.setAttribute("email", rs.getString(3));
				req.setAttribute("pass", rs.getString(4));
				req.setAttribute("dob", rs.getString(5));
				req.setAttribute("age", rs.getString(6));
				req.setAttribute("mobno", rs.getString(7));
				req.setAttribute("gender", rs.getString(8));
				req.setAttribute("address", rs.getString(9));
				req.setAttribute("city", rs.getString(10));
				req.setAttribute("state", rs.getString(11));
				req.setAttribute("coun", rs.getString(12));
				req.setAttribute("degree", rs.getString(13));
				req.setAttribute("passyear", rs.getString(14));

				out.print("Data login Successfully......");

				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.forward(req, resp);

				System.out.println("Data Login successfully");

			} else {

				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Username and password don't match...!');");
				out.println("window.location.href = 'successPage.html';");
				out.println("</script>");

				out.print("<h1 style = 'color: red'>Username and password don't match....</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.forward(req, resp);
			}

		} catch (Exception e) {

		}
	}

}
