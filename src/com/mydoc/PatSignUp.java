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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PatSignUp
 */
@WebServlet("/PatSignUp")
public class PatSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("pname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String phno=request.getParameter("phno");
		
		boolean exist=false;
		
		try {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		if(!exist) {
		PreparedStatement ps=c.prepareStatement("insert into Patients(pname,email,phone,password) values(?,?,?,?)");
		ps.setString(1,pname);
		ps.setString(2,email);
		ps.setString(3,phno);
		ps.setString(4, pass);
		ps.executeUpdate();
		}
		c.close();
		HttpSession session=request.getSession();
		session.setAttribute("pname", pname);
		response.sendRedirect("index.jsp");
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	
		

}
