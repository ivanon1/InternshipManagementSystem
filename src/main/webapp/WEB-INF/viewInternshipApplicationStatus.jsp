<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>View Internship Applications</title>
</head>
<body>
<p>${errorMessage}
	<form name="viewInternshipApplicationStatusForm" method="post" action="/viewInternshipApplicationStatus.do">
		Welcome, ${username} !      <a href="/staff.do">Home</a>      <a href="/login.do">Logout</a>
		<h3>List of Internship Applications</h3>
		<table style="width:100%">
		  <tr>
		  	<th  align="center">Internship Id</th>
		    <th  align="center">Applicant Id</th>
		    <th  align="center">Status</th> 
		  </tr>
		  <c:forEach items="${internshipApplicationList}" var="internshipApplication">			    
			  <tr>
			  		<td align="center">${internshipApplication.internshipId}</td>
					<td align="center">${internshipApplication.applicantId}</td>
					<td align="center">${internshipApplication.internshipApplicationStatus}</td>
        			<td align="center"><a href="reviewInternshipApplication.do?id=${internshipApplication.internshipId}&applicantId=${internshipApplication.applicantId}">Review Application</a></td>  				
			  </tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>