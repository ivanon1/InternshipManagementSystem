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

@WebServlet(urlPatterns ="/makeInternshipViewable.do")

public class MakeInternshipViewableServlet extends HttpServlet{
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			//get parameters value
			int idValue = Integer.parseInt(request.getParameter("id"));
			String userNameValue = (String) request.getSession().getAttribute("username") ;
			String accountTypeValue = (String) request.getSession().getAttribute("accountType") ;
			
			//define internship object
			Internship internship = null;
			
			try {
				//search internship by id
				internship = DBAccess.getInternshipById(idValue);
				//set the attribute value for internship and internshipId
				request.setAttribute("internship", internship);
				request.setAttribute("internshipId", idValue);
				request.getRequestDispatcher("/WEB-INF/makeInternshipViewable.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//catch exception and return error if no internship record found 
				request.setAttribute("errorMessage", "Internship update failed. No internship record found.");
				request.getRequestDispatcher("/WEB-INF/"+accountTypeValue.toLowerCase() +".jsp").forward(request, response);
			}		
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			//get parameter value
			String username = (String) request.getSession().getAttribute("username");
			int idValue = Integer.parseInt(request.getParameter("id"));
			String isViewable = request.getParameter("isViewable");
			
			try {
				//make internship viewable
				DBAccess.makeInternshipViewable(isViewable, idValue, username);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			response.sendRedirect("/viewAllInternshipRecords.do");
	}
}