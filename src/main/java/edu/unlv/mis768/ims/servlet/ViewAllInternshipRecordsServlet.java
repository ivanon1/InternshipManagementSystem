package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/viewAllInternshipRecords.do")

public class ViewAllInternshipRecordsServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		try {
			//get all intenrship records 
			request.setAttribute("internshipList", DBAccess.getAllInternship());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/viewAllInternshipRecords.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/viewAllInternshipRecords.jsp").forward(request, response);
	}

}