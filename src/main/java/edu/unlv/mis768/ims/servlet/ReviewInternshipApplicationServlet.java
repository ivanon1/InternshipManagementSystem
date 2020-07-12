package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unlv.mis768.ims.beans.User;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/reviewInternshipApplication.do")

public class ReviewInternshipApplicationServlet extends HttpServlet{
	
	//define parameter
	int applicantIdValue;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//get parameter values from the request and store in parameter
		int internshipId = Integer.parseInt(request.getParameter("id"));
		int applicantId = Integer.parseInt(request.getParameter("applicantId"));
		applicantIdValue = applicantId;
		try {
			//get internship by id and store attribute in internship
			request.setAttribute("internship", DBAccess.getInternshipById(internshipId));
			//get application id and store attribute in user
			request.setAttribute("user", DBAccess.findUser(applicantId));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/reviewInternshipApplication.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//get parameter values from the request and store in parameter
		String username = (String) request.getSession().getAttribute("username");
		int idValue = Integer.parseInt(request.getParameter("id"));
		
		//if user clicks on approve 
		if(request.getParameter("approve") != null) {
			try {
				//insert record in internship application history for approved status
				DBAccess.updateInternshipApplicationHistory("Approved", idValue, applicantIdValue);
				//update number of filled positions 
				DBAccess.updateInternshipFilledPositions(idValue, username);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		//if user clicks on reject
		else if(request.getParameter("reject")!= null) {
			try {
				//insert record in internship application history for rejected status
				DBAccess.updateInternshipApplicationHistory("Rejected", idValue, applicantIdValue);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}	
		response.sendRedirect("/viewInternshipApplicationStatus.do");
	}

}