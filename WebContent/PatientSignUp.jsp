<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PatientSignIn</title>
</head>
<body>
	<form method="get" action="PatSignUp">
		<table>
		<tr><td>Full Name : </td><td><input name="name" type="text"></td></tr>
		<tr><td>email : </td><td><input name="email" type="email"></td></tr>
		<tr><td>Phone Number : </td><td><input name="phno" type="text"></td></tr>
		<tr><td>Password : </td><td><input name="pass" type="password" ></td></tr>
		<tr><td>Confirm Password : </td><td><input name="confPass" type="password"></td></tr>
		<tr><td><input type="submit" value="submit"></td></tr>
		</table>
	</form>
	
</body>
</html>