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

@WebServlet(urlPatterns ="/login.do")

public class LoginServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//get username and password entered by user
		String nameValue = request.getParameter("username");
		String passwordValue = request.getParameter("password");
		
		try {
			//match entered username and password. if does not match show error message of 'Invalid login credentials' , if match load corresponding user account type page
			if(DBAccess.findUser(nameValue,passwordValue) != null) {
				String accountType = null;
				//get account type
				accountType = DBAccess.findUser(nameValue,passwordValue).getAccountType();
				//verify account type is any one of the listed : student, employer, staff, professor
				if((accountType.equalsIgnoreCase("student")) || (accountType.equalsIgnoreCase("employer")) || (accountType.equalsIgnoreCase("staff")) ||(accountType.equalsIgnoreCase("professor"))) {
					//set session attribute
					request.getSession().setAttribute("username", nameValue);
					request.getSession().setAttribute("accountType", accountType);
					//redirect page to accountype user login
					response.sendRedirect("/"+accountType.toLowerCase()+".do");
				}else {
					//log error if account type is not match
					request.setAttribute("errorMessage", "Invalid credentials!");
					request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				}
			}else {
				//log error if username and password does not match
				request.setAttribute("errorMessage", "Invalid credentials!");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}
}