package com.mydoc;

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


@WebServlet("/DocSignIn")
public class DocSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String dname=request.getParameter("dname");
		String pass=request.getParameter("pass");
		boolean pExist=false;
		try{
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		PreparedStatement ps=c.prepareStatement("select password from Doctors where dname=?");
		ps.setString(1, dname);
		ResultSet rs=ps.executeQuery();
		rs.next();
		while(rs.next()) {
			if(/*rs.getString("dname").equals(dname) &&*/ rs.getString("password").equals(pass)) {
					pExist=true;
					response.sendRedirect("bookAppointment.jsp");
				}
		}
		if(pExist==false) {
			out.println("Invalid Username or password");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
