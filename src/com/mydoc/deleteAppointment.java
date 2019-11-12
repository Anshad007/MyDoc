package com.mydoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteAppointment
 */
@WebServlet("/deleteAppointment")
public class deleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname=request.getParameter("dname");
		HttpSession session=request.getSession();
		String pname=(String)session.getAttribute("pname");
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123") ;
			Statement s=c.createStatement();
			s.executeUpdate("delete from Appointments where dname='"+dname+"' and pname='"+pname+"'");
			response.sendRedirect("bookAppointment.jsp");
		}
			catch(Exception e) {
				System.out.println(e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
