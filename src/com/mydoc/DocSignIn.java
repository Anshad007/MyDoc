package com.mydoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DocSignIn")
public class DocSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname=request.getParameter("dname");
		String pass=request.getParameter("pass");
		
		try{
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		PreparedStatement ps=c.prepareStatement("select password from Doctors where dname=?");
		ps.setString(1, dname);
		ResultSet rs=ps.executeQuery();
		rs.next();
		if(rs.getString("password").equals(pass)) {
			response.sendRedirect("AppointedList.jsp");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
