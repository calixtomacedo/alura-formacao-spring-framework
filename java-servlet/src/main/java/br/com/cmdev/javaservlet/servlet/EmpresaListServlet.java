package br.com.cmdev.javaservlet.servlet;

import java.io.IOException;
import java.util.List;

import br.com.cmdev.javaservlet.model.DataBase;
import br.com.cmdev.javaservlet.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class EmpresaListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase db = new DataBase();
		List<Empresa> empresas = db.getEmpresas();
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> Lista de Empresas </title>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<h2>Lista de Empresas</h2>");
		writer.println("<ul>");
		empresas.stream().forEach(empresa -> { 
			StringBuilder builder = new StringBuilder("<li>");
			builder.append(empresa.getId()).append(" - ").append(empresa.getNome()).append(" - ").append(empresa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("</li>");
			writer.println(builder.toString());
		});
		writer.println("</ul>");
		writer.println("</body>");
		writer.println("</html>");
	}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase db = new DataBase();
		List<Empresa> empresas = db.getEmpresas();
		
		request.setAttribute("empresas", empresas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/empresa-list.jsp");
		dispatcher.forward(request, response);
	}

}
