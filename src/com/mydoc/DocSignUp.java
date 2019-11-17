package com.mydoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DocSignUp")
public class DocSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname=request.getParameter("dname");
		String category=request.getParameter("category");
		String city=request.getParameter("city");
		String email = request.getParameter("email");
		String phone= request.getParameter("phno");
		String pass = request.getParameter("pass");
		int payment = Integer.parseInt(request.getParameter("payment"));
		String time = request.getParameter("time");
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
			PreparedStatement ps=c.prepareStatement("insert into Doctors(dname,email,phone,password,city,category,payment,time) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,dname);
			ps.setString(2,email);
			ps.setString(3,phone);
			ps.setString(4, pass);
			ps.setString(5, city);
			ps.setString(6, category);
			ps.setInt(7, payment);
			ps.setString(8, time);
			ps.executeUpdate();
			HttpSession session=request.getSession();
			session.setAttribute("dname", dname);
			response.sendRedirect("doclogin.jsp");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
