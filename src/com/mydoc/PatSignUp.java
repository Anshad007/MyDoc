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

/**
 * Servlet implementation class PatSignUp
 */
@WebServlet("/PatSignUp")
public class PatSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		//String confPass=request.getParameter("confPass");
		int phno=Integer.parseInt(request.getParameter("phno"));
		
		boolean exist=false;
		
		try {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		Statement s=c.createStatement();
		ResultSet unames=s.executeQuery("select pname from Patients");
		while(unames.next()) {
			if(unames.getString(1).equals(uname)) {
				response.sendRedirect("DoctorSignUp.jsp");
				exist=true;
				break;
			}
			unames.next();
		}
		if(!exist) {
		PreparedStatement ps=c.prepareStatement("insert into Patients(pname,email,phone,password) values(?,?,?,?)");
		ps.setString(1,uname);
		ps.setString(2,email);
		ps.setInt(3,phno);
		ps.setString(4, pass);
		ps.executeUpdate();
		}
		c.close();
		response.sendRedirect("appointment.jsp");
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	
		

}
