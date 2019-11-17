<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<a href="DocLogout" ><button>Log Out</button></a>
<%

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); 

if(session.getAttribute("dname")==null){
	response.sendRedirect("doclogin.jsp");
}

try {
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123") ;
	PreparedStatement ps=c.prepareStatement("select pname from Appointments where dname=?");
	String dname=(String)session.getAttribute("dname");
	ps.setString(1,dname);
	ResultSet rs=ps.executeQuery();
	if(rs==null)
		out.println("<h2>No Patients</h2>");
	else
		out.println("<h2>Patient Name(s)</h2><hr><hr>");
	while(rs.next()){
%>		
	<h4><%=rs.getString("pname") %></h4>
	<hr>
	<% 	
	}
}catch(Exception e){
	System.out.println(e);
}
%>
</body>
</html>