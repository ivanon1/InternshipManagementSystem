<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Account Registration</title>
<script type="text/javascript">
	function showInputText() {
		getSelectedValue = document
				.getElementById('accountType').value;
		if (getSelectedValue.equalsIgnoreCase("Staff")) {
			document.getElementById('major').style.display = "none";
		}
		if (getSelectedValue.equalsIgnoreCase("Professor")) {
			document.getElementById('major').style.display = "none";
		}
		if (getSelectedValue.equalsIgnoreCase("Employer")) {
			document.getElementById('major').style.display = "none";
			document.getElementById('department').style.display = "none";
		}
	}
</script>
</head>
<body>
	<p>${errorMessage}
	<form name="registrationForm" method="post" action="signup">
		<div class="container">
			
			<table>
				<tr>
					<td><h3>Please fill the form to create an account:</h3></td>
				</tr>
				<tr>
					<td><b>Account Type:</b></td>
					<td><select name="accountType" id="accountType" onchange="showInputText();">
							<option value="Student">Student</option>
							<option value="Staff">Staff</option>
							<option value="Employer">Employer</option>
							<option value="Professor">Professor</option>
					</select></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Name:</b></td>
					<td><input type="text" placeholder="Enter Fullname"
						name="name" required></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Address:</b></td>
					<td><input type="text" placeholder="Enter Your Address"
						name="address" required></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Email:</b></td>
					<td><input type="text" placeholder="Enter Email" name="email"
						required></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Phone Number:</b></td>
					<td><input type="text" placeholder="Enter Phone"
						name="phoneNumber" required></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Major:</b></td>
					<td><input type="text" id="major" placeholder="Enter Major" name="major"></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Department:</b></td>
					<td><input type="text" id = "department" placeholder="Enter Department"
						name="department"></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Username:</b></td>
					<td><input type="text" placeholder="Enter Username"
						name="username" required></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Password:</b></td>
					<td><input type="password" placeholder="Enter Password"
						name="password" required></td>
				</tr>
				<tr></tr>
				<tr>
					<td><b>Repeat Password:</b></td>
					<td><input type="password" placeholder="Repeat Password"
						name="password-repeat" required></td>
				</tr>
				<tr></tr>
				<tr></tr>
			</table>
			<br> <input type="submit" value="Register" />
		</div>
	</form>
</body>
</html>