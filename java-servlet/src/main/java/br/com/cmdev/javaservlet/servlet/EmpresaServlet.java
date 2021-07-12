package br.com.cmdev.javaservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresa")
public class EmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresa = request.getParameter("nome");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Company Register</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Name: "+empresa);
		writer.println("</h1>");
		writer.println("<h3>Company successfully registered!</h3>");
		writer.println("</body>");
		writer.println("</html>");
		
		request.getContextPath();
	}
	*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresa = request.getParameter("nome");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Company Register</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Name: "+empresa);
		writer.println("</h1>");
		writer.println("<h3>Company successfully registered!</h3>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
