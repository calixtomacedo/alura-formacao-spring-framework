package br.com.cmdev.javaservletii.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.cmdev.javaservletii.web.model.DataBase;
import br.com.cmdev.javaservletii.web.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaSave implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
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

		return "redirect:controller?action=empresaList";
	}

}
