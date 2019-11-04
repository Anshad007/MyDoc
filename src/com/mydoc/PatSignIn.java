package com.mydoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PatSignIn")
public class PatSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("pname");
		String pass=request.getParameter("pass");
		try {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select pname,password from Patients");
		while(rs.next()) {
			if(rs.getString("pname").equals(pname)) {
				if(rs.getString("password").equals(pass)) {
					response.sendRedirect("bookAppointment.jsp");
				}else {
					response.getWriter().println("Invalid password");
				}
			}
			
			
		}
		}catch(Exception e) {
			System.out.print(e);

		}
	}

}
