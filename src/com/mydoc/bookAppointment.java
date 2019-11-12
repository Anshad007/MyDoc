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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class bookAppointment
 */
@WebServlet("/bookAppointment")
public class bookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session =request.getSession();
		String pname=(String)session.getAttribute("pname");
		String dname=(String)request.getParameter("doctor");
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123") ;
			PreparedStatement lookup=c.prepareStatement("select * from Appointments where pname='"+pname+"' and dname='"+dname+"'");
			ResultSet rs=lookup.executeQuery();
			if(rs.next()) {
				out.println("Appointment already exists");
				out.println("<br><a href=deleteAppointment?dname="+dname+"><button>Delete</button></a>");
			}else {
			String query="insert into Appointments values('"+dname+"','"+pname+"');";
			PreparedStatement ps=c.prepareStatement(query);
			ps.execute();
			out.print("Appointment booked successfully");
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	
	}


