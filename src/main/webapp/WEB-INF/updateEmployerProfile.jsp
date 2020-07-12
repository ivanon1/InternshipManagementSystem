<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Edit Profile</title>
</head>
<body>
	<form name="updateEmployerProfileForm" method="post" action="updateEmployerProfile.do">	
		Welcome, ${username} !      <a href="/employer.do">Home</a>      <a href="/login.do">Logout</a>		
		<p>${errorMessage}
		<div class="container">				
			<h3>Update Profile</h3>
			<table>		
				<tr>
					<td><b>Name:</b></td>
					<td><input type="text" value="${user.name}" name="name" readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr>
					<td><b>Address:</b></td>
					<td><input type="text" value="${user.address}" name="address"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Email:</b></td>
				<td><input type="text" value="${user.email}" name="email"></td></tr>
				<tr></tr>
				<tr><td><b>Phone Number:</b></td>
				<td><input type="text" value="${user.phoneNumber}" name="phoneNumber"></td>
				</tr>				
				<tr></tr>
			</table>
			<br>
			<input type="submit" name="update" value="Update Profile" />
			<input type="submit" name="cancel" value="Cancel"/>
		</div>
	</form>
</body>
</html>