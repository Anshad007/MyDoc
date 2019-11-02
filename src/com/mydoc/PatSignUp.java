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

/**
 * Servlet implementation class PatSignUp
 */
@WebServlet("/PatSignUp")
public class PatSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String confPass=request.getParameter("confPass");
		if(pass.equals(confPass))
			response.sendRedirect("index.html");
		else
			response.sendError(404);
		int phno=Integer.parseInt(request.getParameter("phno"));
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
		PreparedStatement ps=c.prepareStatement("insert into patients(name,email,phone,password) values(?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,email);
		ps.setInt(3,phno);
		ps.setString(4, pass);
		ps.executeUpdate();
		c.close();
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	

}
