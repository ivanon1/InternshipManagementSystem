<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>View Internship</title>
</head>
<body>
<p>${errorMessage}
	<form name="getAllInternshipForm" method="post" action="/viewAllInternshipRecords.do">
		Welcome, ${username} !      <a href="/staff.do">Home</a>      <a href="/login.do">Logout</a>
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
		    <th  align="center">Is Viewable (Y/N)?</th>
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
					<td align="center">${internship.isViewable}</td>
        			<td align="center"><a href="makeInternshipViewable.do?id=${internship.id}">Make Viewable</a></td>  				
			  </tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>