package br.com.cmdev.javaservletii.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public HelloServlet() {
		// Singleton - Instancia única
		System.out.println("CRIANDO A INSTANCIA DO HELLO SERVLET!");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> Your first Servlet - Say Hello </title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Welcome. Congratulations, do you written your first Servlet - Say Hello");
		writer.println("</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
