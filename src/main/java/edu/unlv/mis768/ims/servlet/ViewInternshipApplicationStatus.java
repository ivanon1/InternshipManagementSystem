package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/viewInternshipApplicationStatus.do")

public class ViewInternshipApplicationStatus extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		try {
			//get all internship applicaiton history by status
			request.setAttribute("internshipApplicationList", DBAccess.getInternshipApplicationHistoryByStatus());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/viewInternshipApplicationStatus.jsp").forward(request, response);
	}
}