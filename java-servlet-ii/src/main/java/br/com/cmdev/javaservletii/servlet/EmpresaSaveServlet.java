package br.com.cmdev.javaservletii.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.cmdev.javaservletii.model.DataBase;
import br.com.cmdev.javaservletii.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class EmpresaSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Date dataAbertura;
		try {
			dataAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataabertura"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		DataBase db = new DataBase();
		db.save(empresa);
		
		response.sendRedirect("list");
	}

}
