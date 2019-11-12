package com.mydoc;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/PatSignIn")
public class PatSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String pname=request.getParameter("pname");
		String pass=request.getParameter("pass");
		boolean pExist=false;
		try {
		if(!(pname.equals("")&&pname==null)) {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		PreparedStatement ps=c.prepareStatement("select password from Patients where pname=?");
		ps.setString(1, pname);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if(rs.getString("password").equals(pass)) {
					pExist=true;
					HttpSession session=request.getSession();
					session.setAttribute("pname", pname);
					response.sendRedirect("bookAppointment.jsp");
				}
		}
		}
		if(pExist==false) {
			out.println("Invalid Username or password");
		}
		}catch(Exception e) {
			System.out.print(e);
			//out.println("Invalid Username or password");

		}
	}

}
