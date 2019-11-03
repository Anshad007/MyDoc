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
<title>Find a Doctor</title>
</head>
<body>
		<form action="bookAppointment.jsp" >
		<input  placeholder="Enter Doctor Name" name="doctor" >   <input type="submit" value="search" ><br>
		<select name="city">
			<option>man</option>
		</select><br>
		<select name="category">
			<option>ed</option>
		</select><br>
		<input type="submit" >
		</form>
		<%!public ResultSet doctorsList; %>	
		<%
		String city = request.getParameter("city") ;
		String category = request.getParameter("category") ;
		try{
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
			PreparedStatement ps=c.prepareStatement("select dname,payment from Doctors where city=? and category=?");
			ps.setString(1, city);
			ps.setString(2, category);
			doctorsList=ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);
		}
		while(doctorsList.next()){
			%>
			<form action="demo" >
			<h2><%=doctorsList.getString("dname") %></h2>
			<h2><%=doctorsList.getInt("payment") %></h2>
			<input name="<%=doctorsList.getString("dname") %>" type="submit" value="book" >
			<hr>
			</form>
		<%}%>
		
		
</body>
</html>