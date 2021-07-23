package br.com.cmdev.javaservletii.web.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AutorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("AutorizationFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String actionParam = request.getParameter("action");

		HttpSession session = request.getSession();
		boolean isProtected = !(actionParam.equals("usuarioLogin") || actionParam.equals("loginForm"));
		boolean isUserLogged = !(session.getAttribute("user") != null);
		if (isProtected && isUserLogged) {
			response.sendRedirect("controller?action=loginForm");
			return;
		}

		chain.doFilter(request, response);

	}

}
