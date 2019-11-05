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
<div class="m">
                <nav class="navbar">
                     <ul><li class="nav2">MyDoc</li></ul>
                </nav>
             </div>
    <form class="userreg" action="DocSignUp" method="post">
        <h1>MyDoc</h1>
        <h2>Register Here</h2>
            <input type="text" name="dname" placeholder="Username">
            <input type="text" name="category" placeholder="category">
            <input type="text" name="city" placeholder="City">
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