package edu.unlv.mis768.ims.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//apply filter on the urlpatterns ends with .do
@WebFilter(urlPatterns = {"*.do"})
public class LoginRequiredFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		//verify if username for session is not null. if null redirect page to login page
		if(request.getSession().getAttribute("username")!= null) {
			chain.doFilter(servletRequest, servletResponse);
		}else {
			request.getRequestDispatcher("/login.do").forward(servletRequest, servletResponse);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}

}
