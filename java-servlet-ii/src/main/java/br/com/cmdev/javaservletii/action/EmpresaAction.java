package br.com.cmdev.javaservletii.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import br.com.cmdev.javaservletii.model.DataBase;
import br.com.cmdev.javaservletii.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmpresaAction {

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Date dataabertura;
		try {
			dataabertura = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataabertura"));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataAbertura(dataabertura);
		empresa.setDataCadastro(LocalDateTime.now());

		DataBase db = new DataBase();
		db.adiciona(empresa);

		request.setAttribute("empresa", empresa);

		response.sendRedirect("empresa?action=list");
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase db = new DataBase();
		List<Empresa> empresas = db.getEmpresas();

		request.setAttribute("empresas", empresas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/empresa-list.jsp");
		dispatcher.forward(request, response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		response.sendRedirect("empresa?action=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		DataBase db = new DataBase();
		Empresa empresa = db.findById(id);

		request.setAttribute("empresa", empresa);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/empresa-edit.jsp");
		dispatcher.forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		DataBase db = new DataBase();
		db.delete(id);

		response.sendRedirect("empresa?action=list");
	}

}
