<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Edit Internship</title>
</head>
<body>
	<form name="updateInternshipForm" method="post" action="makeInternshipViewable.do">	
		Welcome, ${username} !      <a href="/staff.do">Home</a>      <a href="/login.do">Logout</a>
		<p>${errorMessage}
		<div class="container">
			<table>				
			<h3>Update Internship</h3>
				<tr>
					<td><b>Internship Id:</b></td>
					<td><input type="text" value="${internship.id}" name="id"  readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr>
					<td><b>Job Title:</b></td>
					<td><input type="text" value="${internship.jobTitle}" name="jobTitle"  readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position Type:</b></td>
				<td><input type="text" value="${internship.positionType}" name="positionType" readonly="readonly" style="color: #787878;"></td></tr>
				<tr></tr>
				<tr><td><b>Employer:</b></td>
				<td><input type="text" value="${internship.employer}" name="employer" readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position Start Date:</b></td>
				<td><input type="date" value="${internship.positionStartDate}" name="positionStartDate" readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Position End Date:</b></td>
				<td><input type="date" value="${internship.positionEndDate}" name="positionEndDate" readonly="readonly" style="color: #787878;"></td>
				</tr>
				<tr></tr>
				<tr><td><b>Geolocation:</b></td>
				<td><input type="text" value="${internship.geolocation}" name="geolocation" readonly="readonly" style="color: #787878;">
				</td> </tr>
				<tr></tr>
				<tr><td><b>Major:</b></td>
				<td><input type="text" value="${internship.major}" name="major" readonly="readonly" style="color: #787878;">
				</td> </tr>
				<tr></tr>
				<tr><td><b>Department:</b></td>
				<td><input type="text" value="${internship.department}" name="department" readonly="readonly" style="color: #787878;">
				</td></tr>
				<tr></tr>
				<tr><td><b>Pay:</b></td>
				<td><input type="text" value="${internship.pay}" name="pay"	readonly="readonly" style="color: #787878;">
				</td></tr>
				<tr></tr>
				<tr><td><b>Semester:</b></td>
				<td><input type="text" value="${internship.semester}" name="semester" readonly="readonly" style="color: #787878;">
				</td></tr>
				<tr></tr>
				<tr><td><b>Reference:</b></td>
				<td><input type="text" value="${internship.reference}" name="reference" readonly="readonly" style="color: #787878;">
				</td></tr>
				<tr></tr>
				<tr><td><b>Total Number of Positions:</b></td>
				<td><input type="text" value="${internship.totalNumOfPositions}" name="noOfPositionsAvailable" readonly="readonly" style="color: #787878;">
				</td></tr>
				<tr></tr>
				<tr><td><b>Is Viewable (Y/N)?:</b></td>
				<td><input type="text" value="${internship.isViewable}" name="isViewable">		
				</td></tr>
				<tr></tr>
				<tr></tr>
			</table>
			<br>
			<input type="submit" value="Update Internship" />
		</div>
	</form>
</body>
</html>