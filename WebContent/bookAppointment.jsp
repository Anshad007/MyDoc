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
<a href="PatLogout" ><button>Log Out</button></a>
<%System.out.println("in bookAppointment.jsp"); %>
	<%
		if(session.getAttribute("pname")==null){
			response.sendRedirect("index.jsp");
		}
	%>

		<form action="bookAppointment.jsp" >
		<!--  <input  placeholder="Enter Doctor Name" name="doctor" >   <input type="submit" value="search" ><br>-->
		Select City : 
		<select name="category">
			<option>--Select--</option>
			<option>Podiatrist</option>
			<option>General Practitioner</option>
			<option>Pediatrician</option>
			<option>Endocrinologist</option>
			<option>Neurologist</option>
			<option>Rheumatologist</option>
			<option>Allergist/Immunologist</option>
			<option>Psychiatrist</option>
			<option>Nephrologist</option>
			<option>OB/GYN</option>
			<option>Oncologist</option>
			<option>Urologist</option>
			<option>Cardiologist</option>
		</select>
		&nbsp &nbsp &nbsp 
		Select Category : 
		<select name="city">
			<option>--Select--</option>
			<option>Mangalore</option>
			<option>Kochi</option>
			<option>Bangalore</option>
			<option>Chennai</option>
		</select><br><br>
		<input type="submit" value="search" >
		</form>
		<%!public ResultSet doctorsList; %>	
		<%
		String city = request.getParameter("city") ;
		String category = request.getParameter("category") ;
		try{
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDoc","testuser","testuser123");
			PreparedStatement ps=c.prepareStatement("select dname,payment,time,phone from Doctors where city=? and category=?");
			ps.setString(1, city);
			ps.setString(2, category);
			doctorsList=ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);
		}
		while(doctorsList.next()){
			%>
			
			<h2><%=doctorsList.getString("dname") %></h2>
			<h4>payment fee : <%=doctorsList.getInt("payment") %></h4>
			<h4>Timings : <%=doctorsList.getString("time") %></h4>
			<h4>Ph.no : <%=doctorsList.getString("phone") %></h4>
			<a  href="bookAppointment?doctor=<%=doctorsList.getString("dname")%>"><button>click</button></a>
			<hr>
		<%}%>
		
	
</body>
</html>