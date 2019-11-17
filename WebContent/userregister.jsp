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
<!-- <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %> -->
 <div class="m">
                <nav class="navbar">
                     <ul><li class="nav2">MyDoc</li></ul>
                </nav>
             </div>
    <form class="userreg" action="PatSignUp" method="post">
        <h1>MyDoc</h1>
        <h2>Register Here</h2>
            <input type="text" name="pname" placeholder="Full Name">
            <input type="email" name="email" placeholder="Email">
            <input type="tel" name="phno" placeholder="Phone Number">
            <input type="password" name="pass" placeholder="Password">
            <input type="password" name="confPass" placeholder="Confirm Password">
            <input type="submit" value="Register">
    </form>
</body>
</html>