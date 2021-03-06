package br.com.cmdev.javaservletii.web.filters;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.com.cmdev.javaservletii.web.action.Action;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControllerFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String actionParam = request.getParameter("action");

		String className = createClassName(request, actionParam);
		String destinationType = null;
		try {
			Action action = (Action) Class.forName(className).getConstructor().newInstance();
			destinationType = action.execute(request);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new ServletException(e);
		}

		String[] destinationUrl = destinationType.split(":");
		if (destinationUrl[0].equalsIgnoreCase("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(destinationUrl[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(destinationUrl[1]);
		}
	}

	private String createClassName(HttpServletRequest request, String action) {
		String firstLetter = action.substring(0, 1);
		String className = action.replaceFirst(firstLetter, firstLetter.toUpperCase());
		return Action.class.getPackageName().concat(".").concat(className);
	}

}
