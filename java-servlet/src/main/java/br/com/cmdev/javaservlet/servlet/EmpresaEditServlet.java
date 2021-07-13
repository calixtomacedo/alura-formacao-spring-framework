package br.com.cmdev.javaservlet.servlet;

import java.io.IOException;

import br.com.cmdev.javaservlet.model.DataBase;
import br.com.cmdev.javaservlet.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EmpresaEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		
		DataBase db = new DataBase();
		Empresa empresa = db.findById(id);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/empresa-edit.jsp");
		dispatcher.forward(request, response);
	}

}
