<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Staff View</title>
</head>
<body>
	<p>${successMessage}
	<form name="staffViewForm" method="post" action="staff.do">		
		Welcome, ${username} ! <a href="/login.do">Logout</a>
		<ul>
			<li><strong>Home</strong></li>
			<li><a href="updateStaffProfile.do">Profile</a></li>
		</ul>
		<ul>
			<li><strong>Internship</strong></li>
			<li><a href="viewAllInternshipRecords.do">View Internships</a></li>
			<li><a href="createInternship.do">Create/Edit Internship</a></li>
			<li><a href="viewInternshipApplicationStatus.do">View Pending Internship Applications</a></li>
		</ul>
	</form>
</body>
</html>