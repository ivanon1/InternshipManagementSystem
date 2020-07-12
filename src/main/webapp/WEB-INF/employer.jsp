<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Employer View</title>
</head>
<body>
	<p>${successMessage}
	<form name="employerViewForm" method="post" action="employer.do">		
		Welcome, ${username} ! <a href="/login.do">Logout</a>
		<ul>
			<li><strong>Home</strong></li>
			<li><a href="updateEmployerProfile.do">Profile</a></li>
		</ul>
		<ul>
			<li><strong>Internship</strong></li>
			<li><a href="/createInternship.do">Create/Edit Internship</a></li>	
		</ul>
	</form>
</body>
</html>