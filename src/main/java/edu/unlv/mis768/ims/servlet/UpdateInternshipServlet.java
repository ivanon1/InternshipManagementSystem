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
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/updateInternship.do")

public class UpdateInternshipServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//define variables from session attribute
		int idValue = Integer.parseInt(request.getParameter("id"));
		String userNameValue = (String) request.getSession().getAttribute("username") ;
		String accountTypeValue = (String) request.getSession().getAttribute("accountType") ;
		//define internship objec
		Internship internship = null;
		
		try {
			//get internship record by id
			internship = DBAccess.getInternshipById(idValue);
		} catch (SQLException e) {
			//catch exception if no internship record found
			System.out.println(e.getMessage());
			request.setAttribute("errorMessage", "Internship update failed. No internship record found.");
			request.getRequestDispatcher("/WEB-INF/"+accountTypeValue.toLowerCase() +".jsp").forward(request, response);
		}
		//set request attribute for intenrship, internship id and accountType
		request.setAttribute("internship", internship);
		request.setAttribute("internshipId", idValue);
		request.setAttribute("accountType", accountTypeValue.toLowerCase());
		request.getRequestDispatcher("/WEB-INF/updateInternship.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//get parameter values form update intenrship form
		int idValue = Integer.parseInt(request.getParameter("id"));
		String jobTitleValue = request.getParameter("jobTitle");
		String positionTypeValue = request.getParameter("positionType");
		String employerValue = request.getParameter("employer");
		
	    
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
		
		//create internship object and set hte values captured from update internship form
		Internship internship = new Internship();
		internship.setId(idValue);
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
		String accountTypeValue = (String) request.getSession().getAttribute("accountType") ;
		
		try {
			//update intenrship record
			DBAccess.updateInternship(internship,userNameValue);
			response.sendRedirect("/createInternship.do");
		} catch (SQLException e) {
			//capture exception if intenrship update failed
			System.out.println(e.getMessage());
			request.setAttribute("errorMessage", "Internship updation failed.");
			request.getRequestDispatcher("/WEB-INF/updateInternship.jsp").forward(request, response);
		}
	}
}