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

@WebServlet(urlPatterns ="/student.do")

public class StudentServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{		
		request.getRequestDispatcher("/WEB-INF/student.jsp").forward(request, response);
	}	
}