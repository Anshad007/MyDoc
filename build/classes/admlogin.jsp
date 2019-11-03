<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style4.css">
<title>MyDoc</title>
</head>
<body>
<div class="m">
   <nav class="navbar">
        <ul><li class="nav2">MyDoc</li></ul>
       <ul class="nav1">
           <li ><a  href="index.jsp">Home</a></li>
       </ul>
   </nav>
</div>
<div class="heading">
<H1 class="medi">MyDoc</H1>
<h2>Online Doctor Appointment</h2>
</div>
<form  class="user" action="login" method="post">
    <h2>Welcome Admin</h2>
    <input type="text" name="name" placeholder="Username">
   <input type="password" name="password" placeholder="Password">
   <input type="submit" value="login">
</form>
</body>
</html>