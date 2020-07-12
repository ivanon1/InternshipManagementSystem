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

@WebServlet(urlPatterns ="/signup")

public class SignupServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//get parameter value from the signup form
		String accountTypeValue = request.getParameter("accountType");
		String nameValue = request.getParameter("name");
		String addressValue = request.getParameter("address");
		String emailValue = request.getParameter("email");
		String phoneNumberValue = request.getParameter("phoneNumber");
		String majorValue = request.getParameter("major");
		String departmentValue = request.getParameter("department");
		String usernameValue = request.getParameter("username");
		String passwordValue = request.getParameter("password");
		String repeatPasswordValue = request.getParameter("password-repeat");
		
		//verify if password and repeat password value are same or not. if same , create the account. if not same, fail the account creation
		if(passwordValue.equals(repeatPasswordValue)) {
			
			//if account type selected as student, create student account
			if(accountTypeValue.equalsIgnoreCase("student")) {
				Student user = new Student();
				user.setAccountType(accountTypeValue);
				user.setName(nameValue);
				user.setAddress(addressValue);
				user.setEmail(emailValue);
				user.setPhoneNumber(phoneNumberValue);
				user.setMajor(majorValue);
				user.setDepartment(departmentValue);
				user.setUsername(usernameValue);
				user.setPassword(passwordValue);
				
				try {
					//create user account
					DBAccess.createUserAccount(user);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			//if account type selected as student, create staff account
			if(accountTypeValue.equalsIgnoreCase("staff")) {
				Staff user = new Staff();
				user.setAccountType(accountTypeValue);
				user.setName(nameValue);
				user.setAddress(addressValue);
				user.setEmail(emailValue);
				user.setPhoneNumber(phoneNumberValue);
				user.setDepartment(departmentValue);
				user.setUsername(usernameValue);
				user.setPassword(passwordValue);
				
				try {
					//create user account
					DBAccess.createUserAccount(user);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			//if account type selected as student, create professor account
			if(accountTypeValue.equalsIgnoreCase("professor")) {
				Professor user = new Professor();
				user.setAccountType(accountTypeValue);
				user.setName(nameValue);
				user.setAddress(addressValue);
				user.setEmail(emailValue);
				user.setPhoneNumber(phoneNumberValue);
				user.setDepartment(departmentValue);
				user.setUsername(usernameValue);
				user.setPassword(passwordValue);
				
				try {
					//create user account
					DBAccess.createUserAccount(user);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			//if account type selected as student, create employer account
			if(accountTypeValue.equalsIgnoreCase("employer")) {
				Employer user = new Employer();
				user.setAccountType(accountTypeValue);
				user.setName(nameValue);
				user.setAddress(addressValue);
				user.setEmail(emailValue);
				user.setPhoneNumber(phoneNumberValue);
				user.setUsername(usernameValue);
				user.setPassword(passwordValue);
				
				try {
					//create user account
					DBAccess.createUserAccount(user);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			
			request.setAttribute("successMessage", "User account created successfully.");
			response.sendRedirect("/login.do");
			
		}else {
			request.setAttribute("errorMessage", "Password mismatch. Please retype the password");
			request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}
	}
}