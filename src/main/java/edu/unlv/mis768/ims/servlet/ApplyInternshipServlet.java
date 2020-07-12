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

@WebServlet(urlPatterns ="/applyInternship.do")

public class ApplyInternshipServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		//get parameter value for id
		int idValue = Integer.parseInt(request.getParameter("id"));		
		//create an internship object
		Internship internship = null;
		
		try {
			//get internship records by internship id
			internship = DBAccess.getInternshipById(idValue);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("errorMessage", "No internship record found.");
		}
		
		//set the attribute value for internship
		request.setAttribute("internship", internship);
		request.getRequestDispatcher("/WEB-INF/applyInternship.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//get parameter value for id
		int idValue = Integer.parseInt(request.getParameter("id"));
		//get user id from session
		String userNameValue = (String) request.getSession().getAttribute("username") ;
		
			try {
				//apply for selected internship record
				DBAccess.insertInternshipApplicationHistory(idValue,"Applied",userNameValue);
				request.setAttribute("successMessage", "Internship application for internship id "+ idValue + " submitted successfully.");
				//redirect page to search internship
				response.sendRedirect("/searchInternship.do");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//log the failure if internship record update fails
				request.setAttribute("errorMessage", "Internship application for internship id " + idValue + " failed.");
				request.getRequestDispatcher("/WEB-INF/applyInternship.jsp").forward(request, response);
			}
	}
}