package edu.unlv.mis768.ims.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ="/staff.do")

public class StaffServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/WEB-INF/staff.jsp").forward(request, response);
	}	
}