package com.mydoc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bookAppointment
 */
@WebServlet("/bookAppointment")
public class bookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String doc=(String)request.getParameter("doctor");
		response.getWriter().println(doc);
	}

	
	}


