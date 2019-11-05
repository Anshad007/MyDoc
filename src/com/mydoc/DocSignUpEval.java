package com.mydoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class DocSignUpEval
 */
@WebFilter("/DocSignUp")
public class DocSignUpEval implements Filter {

    /**
     * Default constructor. 
     */
    public DocSignUpEval() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		PrintWriter out=response.getWriter();
		boolean exist=false;
		boolean invalid=false;
		String dname=request.getParameter("dname");
		String phno=(String)request.getParameter("phno");
		String pass=request.getParameter("pass");
		String confPass=request.getParameter("confPass");
		try {
		
		//to validate username string	
		if( (dname.equals("")) || (dname==null) || !(dname.matches("^[a-zA-Z]*$")) ) {
			invalid=true;
			out.println("Invalid Username(Must contain only Alphabets)");
		}
		
		if(!invalid) {	
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
			Statement s=c.createStatement();	
			ResultSet rs=s.executeQuery("select dname from Doctors;");
			while(rs.next()) {
				if(rs.getString("dname").equals(dname)) {
					exist=true;
					break;
				}
			}
			}
			if( exist && !invalid )
				out.print("Username already exists");
			
		
		if( pass.equals("") || pass==null && !invalid )
			out.println("Invalid Password");
			
		if( !(phno.matches("(0/91)?[7-9][0-9]{9}")) && !invalid ) {  
			out.println("Invalid Phone Number");
			invalid=true;
		}
		
		if( !(pass.equals(confPass)) && !invalid )
			out.println("Passwords don't match");
			
		if( !exist && !invalid ) 
			chain.doFilter(request, response);	
		
		
		}catch(Exception e) {
			System.out.println(e);
		}

		
		// pass the request along the filter chain
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
