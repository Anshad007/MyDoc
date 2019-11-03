<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDoc</title>
<link rel="stylesheet" href="style3.css">
</head>
<body>
 <div class="m">
                <nav class="navbar">
                     <ul><li class="nav2">MyDoc</li></ul>
                </nav>
             </div>
    <form class="userreg" action="register" method="post">
        <h1>MyDoc</h1>
        <h2>Register Here</h2>
            <input type="text" name="fname" placeholder="First name">
            <input type="text" name="lname" placeholder="Last name">
            <input type="text" name="uemail" placeholder="Email">
            <input type="text" name="uemail" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Register">
    </form>
</body>
</html>