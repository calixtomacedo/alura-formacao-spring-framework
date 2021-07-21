package br.com.cmdev.javaservletii.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import br.com.cmdev.javaservletii.model.DataBase;
import br.com.cmdev.javaservletii.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaCreate implements Action {

	public String execute(HttpServletRequest request) throws ServletException, IOException {
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

		return "redirect:controller?action=empresaList";
	}

}
