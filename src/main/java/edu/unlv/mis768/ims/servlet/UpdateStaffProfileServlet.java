package edu.unlv.mis768.ims.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unlv.mis768.ims.beans.Employer;
import edu.unlv.mis768.ims.beans.Professor;
import edu.unlv.mis768.ims.beans.Staff;
import edu.unlv.mis768.ims.beans.Student;
import edu.unlv.mis768.ims.beans.User;
import edu.unlv.mis768.ims.conn.DBAccess;

@WebServlet(urlPatterns ="/updateStaffProfile.do")

public class UpdateStaffProfileServlet extends HttpServlet{	
	
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//define variables from session attribute
		User user = null;
		String userNameValue = (String) request.getSession().getAttribute("username") ;
		String accountTypeValue = (String) request.getSession().getAttribute("accountType") ;

		try {
			//find user by username
			user = DBAccess.findUser(userNameValue);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("errorMessage", "User profile not found.");
		}
		//set attribute of user from user object
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/updateStaffProfile.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{		
		//define variables from session attribute
		String userNameValue = (String) request.getSession().getAttribute("username") ;
		String accountTypeValue = (String) request.getSession().getAttribute("accountType") ;

		//get parameter value from staff profile page
		Staff user = new Staff();
		user.setName(request.getParameter("name"));
		user.setAddress(request.getParameter("address"));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setDepartment(request.getParameter("department"));
		user.setUsername(userNameValue);
		//if user cancels the profile update
		if(request.getParameter("cancel") != null) {
			//do nothing
		}
		//if user clicks on update, update the user profile
		else if(request.getParameter("update") != null) {
			try {
				//update user profile
				DBAccess.updateUserAccount(user);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		//redirect page to user account type page
		response.sendRedirect("/"+accountTypeValue.toLowerCase()+".do");
	}
}