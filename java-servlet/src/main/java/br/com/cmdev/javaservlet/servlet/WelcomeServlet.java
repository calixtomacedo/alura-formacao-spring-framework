package br.com.cmdev.javaservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/welcome")
public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = -900071542486715106L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> Your first Servlet </title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Welcome. Congratulations, do you written your first Servlet!");
		writer.println("</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
