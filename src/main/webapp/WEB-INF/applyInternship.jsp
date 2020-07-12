<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Apply Internship</title>
</head>
<body>

	<form name="applyInternshipForm" method="post" action="applyInternship.do">	
		Welcome, ${username} !      <a href="/student.do">Home</a>      <a href="/login.do">Logout</a>
		<p>${errorMessage}
		<div class="container">
			<table>				
			<h3>Apply Internship</h3>
				<tr>
					<td><b>Internship Id:</b></td>
					<td><input type="text" value="${internship.id}" name="id"  readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr>
					<td><b>Job Title:</b></td>
					<td><input type="text" value="${internship.jobTitle}" name="jobTitle"  readonly = "readonly" style="color: #787878;"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position Type:</b></td>
				<td><input type="text" value="${internship.positionType}" name="positionType" readonly = "readonly" style="color: #787878;"></td></tr>
				<tr></tr>
				<tr><td><b>Employer:</b></td>
				<td><input type="text" value="${internship.employer}" name="employer" readonly = "readonly" style="color: #787878;"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Geolocation:</b></td>
				<td><input type="text" value="${internship.geolocation}" name="geolocation" readonly = "readonly" style="color: #787878;">
				</td> </tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
			</table>
			<br>
			<input type="submit" value="Apply Internship" />
		</div>
	</form>
</body>
</html>