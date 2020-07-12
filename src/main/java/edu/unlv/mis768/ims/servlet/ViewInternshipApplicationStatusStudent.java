package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/viewInternshipApplicationStatusStudent.do")

public class ViewInternshipApplicationStatusStudent extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String userNameValue = (String) request.getSession().getAttribute("username") ;
		try {
			//get all internship applicaiton history
			request.setAttribute("internshipApplicationList", DBAccess.getInternshipApplicationHistory(userNameValue));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/viewInternshipApplicationStatusStudent.jsp").forward(request, response);
	}
}