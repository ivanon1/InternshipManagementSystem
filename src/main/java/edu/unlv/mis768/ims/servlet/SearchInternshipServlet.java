package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unlv.mis768.ims.beans.Internship;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/searchInternship.do")

public class SearchInternshipServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//get parameter value and set to "" if the value return as NULL
		String pJobTitle = request.getParameter("jobTitle");
		if(pJobTitle!=null) {
		}else {
			pJobTitle = "";			
		}
		String pPositionType = request.getParameter("positionType");
		if(pPositionType!=null) {
		}else {
			pPositionType = "";			
		}
		String pEmployer = request.getParameter("employer");
		if(pEmployer!=null) {			
		}else {
			pEmployer = "";
		}
		String pGeolocation = request.getParameter("geolocation");
		if(pGeolocation != null) {
			
		}else {
			pGeolocation = "";
		}
		String pMajor = request.getParameter("major");
		if(pMajor!=null) {
			
		}else {
			pMajor = "";
		}
		String pDepartment = request.getParameter("department");
		if(pDepartment!=null) {
			
		}else {
			pDepartment = "";
		}
		String pSemester = request.getParameter("semester");
		if(pSemester!=null) {			
		}else {
			pSemester = "";
		}
		
		//create internship object and set the values
		Internship internship = new Internship();
		internship.setJobTitle(pJobTitle);
		internship.setDepartment(pDepartment);
		internship.setPositionType(pPositionType);
		internship.setEmployer(pEmployer);
		internship.setGeolocation(pGeolocation);
		internship.setMajor(pMajor);
		internship.setSemester(pSemester);
		try {
			//search internship record by set filters
			request.setAttribute("internshipList", DBAccess.searchInternship(internship));	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/searchInternship.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//get parameter value and set to "" if the value return as NULL
		String pJobTitle = request.getParameter("jobTitle");
		if(pJobTitle!=null) {
		}else {
			pJobTitle = "";			
		}
		String pPositionType = request.getParameter("positionType");
		if(pPositionType!=null) {
		}else {
			pPositionType = "";			
		}
		String pEmployer = request.getParameter("employer");
		if(pEmployer!=null) {			
		}else {
			pEmployer = "";
		}
		String pGeolocation = request.getParameter("geolocation");
		if(pGeolocation != null) {
			
		}else {
			pGeolocation = "";
		}
		String pMajor = request.getParameter("major");
		if(pMajor!=null) {
			
		}else {
			pMajor = "";
		}
		String pDepartment = request.getParameter("department");
		if(pDepartment!=null) {
			
		}else {
			pDepartment = "";
		}
		String pSemester = request.getParameter("semester");
		if(pSemester!=null) {			
		}else {
			pSemester = "";
		}
		
		//create internship object and set the values
		Internship internship = new Internship();
		internship.setJobTitle(pJobTitle);
		internship.setDepartment(pDepartment);
		internship.setPositionType(pPositionType);
		internship.setEmployer(pEmployer);
		internship.setGeolocation(pGeolocation);
		internship.setMajor(pMajor);
		internship.setSemester(pSemester);
		try {
			//search internship record by set filters
			request.setAttribute("internshipList", DBAccess.searchInternship(internship));	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/searchInternship.jsp").forward(request, response);
	}

}