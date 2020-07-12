<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Login to IMS</title>
</head>
<body>
	<form name="loginForm" method="post" action="login.do">
		<table> 
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr><td><b>${errorMessage}</b></td></tr>
			<tr></tr>
			<tr><td>User Name:</td><td><input type="text" name="username" /></td></tr>
			<tr></tr>
			<tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
			<tr><td><input type="submit" value="Login" /></td><td><a href="/signup">Do not have account?</a></td></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
	</form>
	
</body>
</html>