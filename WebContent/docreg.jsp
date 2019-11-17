<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style6.css">
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>
<div class="m">
   <nav class="navbar">
        <ul><li class="nav2">MyDoc</li></ul>
       <ul class="nav1">
            <li ><a  href="index.jsp">Home</a></li>
           <li ><a  href="admlogin.jsp">Admin</a></li>
           <li><a  href="doclogin.jsp">Doctor</a></li>
           <li ><a  href="about.jsp">About_us</a></li>
       </ul>
   </nav>
</div>
    <form class="userreg" action="DocSignUp" method="post">
        <h1>MyDoc</h1>
        <h2>Register Here</h2>
            <input type="text" name="dname" placeholder="Username">
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
			</select><br>
		    <select name="city">
				<option>--Select--</option>
				<option>Mangalore</option>
				<option>Kochi</option>
				<option>Bangalore</option>
				<option>Chennai</option>
			</select>
            <input type="email" name="email" placeholder="Email">
            <input type="tel" name="phno" placeholder="Phone Number" >  
            <input type="text" name="time" placeholder="working time">
            <input type="text" name="payment" placeholder="Average Working Fee">
            <input type="password" name="pass" placeholder="Password">
       		<input type="password" name="confPass" placeholder="Confirm Password">
            <input type="submit" value="Register">
    </form>
</body>
</html>