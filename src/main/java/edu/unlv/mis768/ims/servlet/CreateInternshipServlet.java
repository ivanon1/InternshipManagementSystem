package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unlv.mis768.ims.beans.Internship;
import edu.unlv.mis768.ims.beans.User;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/createInternship.do")

public class CreateInternshipServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//get session attribute for accounttype
		String accountType = (String) request.getSession().getAttribute("accountType");
		request.setAttribute("accountType", accountType.toLowerCase());
		try {
			//get internship record list by logged in user
			request.setAttribute("internshipList", DBAccess.getInternshipByLoggedInUser((String) request.getSession().getAttribute("username")));			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/createInternship.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//get values entered in the create internship form 
		String jobTitleValue = request.getParameter("jobTitle");
		String positionTypeValue = request.getParameter("positionType");
		String employerValue = request.getParameter("employer");
		
	    //convert the java util.date format to sql.date format
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String sParameter = request.getParameter("positionStartDate"); 
		String eParameter = request.getParameter("positionEndDate"); 
		java.util.Date sDateParameter = null;
		try {
			sDateParameter = df.parse(sParameter);
		} catch (ParseException e1) {
			System.out.println(e1.getMessage());
		}
		java.sql.Date positionStartDateValue = new java.sql.Date(sDateParameter.getTime());
		
		java.util.Date eDateParameter = null;
		try {
			eDateParameter = df.parse(eParameter);
		} catch (ParseException e1) {
			System.out.println(e1.getMessage());
		}
		java.sql.Date positionEndDateValue = new java.sql.Date(eDateParameter.getTime());
		
		String geolocationValue = request.getParameter("geolocation");
		String majorValue = request.getParameter("major");
		String departmentValue = request.getParameter("department");
		Double payValue = Double.parseDouble(request.getParameter("pay"));
		String semesterValue = request.getParameter("semester");
		String referenceValue = request.getParameter("reference");
		Integer noOfPositionsAvailableValue = Integer.parseInt(request.getParameter("noOfPositionsAvailable"));
		
		//create internship object and set the values for each field
		Internship internship = new Internship();
		internship.setJobTitle(jobTitleValue);
		internship.setPositionType(positionTypeValue);
		internship.setEmployer(employerValue);
		internship.setPositionStartDate(positionStartDateValue);
		internship.setPositionEndDate(positionEndDateValue);
		internship.setGeolocation(geolocationValue);
		internship.setMajor(majorValue);
		internship.setDepartment(departmentValue);
		internship.setPay(payValue);
		internship.setSemester(semesterValue);
		internship.setReference(referenceValue);
		internship.setTotalNumOfPositions(noOfPositionsAvailableValue);
		String userNameValue = (String) request.getSession().getAttribute("username") ;
		
			try {
				//add internship record
				DBAccess.addInternship(internship,userNameValue);
				//redirect page to create internship
				response.sendRedirect("/createInternship.do");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//log error if internship creation failed
				request.setAttribute("errorMessage", "Internship creation failed.");
				request.getRequestDispatcher("/WEB-INF/createInternship.jsp").forward(request, response);
			}
	}
}