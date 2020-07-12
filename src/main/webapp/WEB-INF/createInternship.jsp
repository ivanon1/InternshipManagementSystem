<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Create Internship</title>
</head>
<body>

	<form name="createUpdateInternshipForm" method="post" action="createInternship.do">	
		Welcome, ${username} !      <a href="/${accountType}.do">Home</a>      <a href="/login.do">Logout</a>
		<p>${errorMessage}
		<div class="container">
			<table>			
				<h3>Create Internship</h3>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>		
				<tr>
					<td><b>Job Title:</b></td>
					<td><input type="text" placeholder="Job title" name="jobTitle"  required></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position Type:</b></td>
				<td><input type="text" placeholder="Position type" name="positionType" required></td></tr>
				<tr></tr>
				<tr><td><b>Employer:</b></td>
				<td><input type="text" placeholder="Employer name" name="employer" required></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position Start Date:</b></td>
				<td><input type="date" placeholder="Position start date (yyyy-MM-dd)" name="positionStartDate" required></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position End Date:</b></td>
				<td><input type="date" placeholder="Position end date (yyyy-MM-dd)" name="positionEndDate" required></td>
				</tr>
				<tr></tr>
				<tr><td><b>Geolocation:</b></td>
				<td><input type="text" placeholder="Geolocation" name="geolocation" required>
				</td> </tr>
				<tr></tr>
				<tr><td><b>Major:</b></td>
				<td><input type="text" placeholder="Major" name="major" required>
				</td> </tr>
				<tr></tr>
				<tr><td><b>Department:</b></td>
				<td><input type="text" placeholder="Department" name="department" required>
				</td></tr>
				<tr></tr>
				<tr><td><b>Pay:</b></td>
				<td><input type="text" placeholder="Amount payable($)" name="pay"	required>
				</td></tr>
				<tr></tr>
				<tr><td><b>Semester:</b></td>
				<td><input type="text" placeholder="Semester" name="semester">
				</td></tr>
				<tr></tr>
				<tr><td><b>Reference:</b></td>
				<td><input type="text" placeholder="Reference"
					name="reference">
				</td></tr>
				<tr></tr>
				<tr><td><b>Total Number of Positions:</b></td>
				<td><input type="text" placeholder="Total number of available positions"
					name="noOfPositionsAvailable">
				</td></tr>
				<tr></tr>
				<tr></tr>
			</table>
			<br>
			<input type="submit" value="Create Internship" />
		</div>
		<br>
		<br>
		<h3>List of Internships</h3>
		<table style="width:100%">
		  <tr>
		  	<th  align="center">Internship Id</th>
		    <th  align="center">Job Title</th>
		    <th  align="center">Position Type</th> 
		    <th  align="center">Employer</th>
		    <th  align="center">Position Start Date</th>
		    <th  align="center">Position End Date</th>
		    <th  align="center">Geolocation</th>
		    <th  align="center">Major</th>
		    <th  align="center">Department</th>
		    <th  align="center">Pay($)</th>
		    <th  align="center">Semester</th>
		    <th  align="center">Reference</th>
		    <th  align="center">Total Number of Positions</th>
		    <th  align="center">Total Number of Positions Filled</th>
		  </tr>
		  <c:forEach items="${internshipList}" var="internship">			    
			  <tr>
			  		<td align="center">${internship.id}</td>
					<td align="center">${internship.jobTitle}</td>
					<td align="center">${internship.positionType}</td>
					<td align="center">${internship.employer}</td>
					<td align="center">${internship.positionStartDate}</td>
					<td align="center">${internship.positionEndDate}</td>
					<td align="center">${internship.geolocation}</td>
					<td align="center">${internship.major}</td>
					<td align="center">${internship.department}</td>
					<td align="center">$${internship.pay}</td>
					<td align="center">${internship.semester}</td>
					<td align="center">${internship.reference}</td>
					<td align="center">${internship.totalNumOfPositions}</td>
					<td align="center">${internship.totalNumOfFilledPositions}</td>
					<td align="center"><a href="updateInternship.do?id=${internship.id}">edit</a></td>
			  </tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>