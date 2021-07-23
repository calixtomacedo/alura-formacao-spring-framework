package br.com.cmdev.javaservletii.web.action;

import java.io.IOException;

import br.com.cmdev.javaservletii.web.model.DataBase;
import br.com.cmdev.javaservletii.web.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaEdit implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		DataBase db = new DataBase();
		Empresa empresa = db.findById(id);

		request.setAttribute("empresa", empresa);

		return "forward:/pages/empresa-edit.jsp";
	}

}
