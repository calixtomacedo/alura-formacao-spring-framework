package br.com.cmdev.javaservletii.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.com.cmdev.javaservletii.web.action.Action;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
