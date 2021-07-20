package br.com.cmdev.javaservletii.servlet;

import java.io.IOException;

import br.com.cmdev.javaservletii.action.EmpresaAction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresa")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("create")) {
			new EmpresaAction().create(request, response);
		} else if (action.equals("save")) {
			new EmpresaAction().save(request, response);
		} else if (action.equals("list")) {
			new EmpresaAction().list(request, response);
		} else if (action.startsWith("edit")) {
			new EmpresaAction().edit(request, response);
		} else if (action.startsWith("delete")) {
			new EmpresaAction().delete(request, response);
		}
	}

}
