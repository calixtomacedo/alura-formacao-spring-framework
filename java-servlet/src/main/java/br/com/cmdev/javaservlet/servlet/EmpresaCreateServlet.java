package br.com.cmdev.javaservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import br.com.cmdev.javaservlet.model.DataBase;
import br.com.cmdev.javaservlet.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresa")
public class EmpresaCreateServlet extends HttpServlet {
	
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
		String nome = request.getParameter("nome");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Company Register</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Name: "+nome);
		writer.println("</h1>");
		writer.println("<h3>Company successfully registered!</h3>");
		writer.println("</body>");
		writer.println("</html>");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataCadastro(LocalDateTime.now());
		
		DataBase db = new DataBase();
		db.adiciona(empresa);
		
	}

}
