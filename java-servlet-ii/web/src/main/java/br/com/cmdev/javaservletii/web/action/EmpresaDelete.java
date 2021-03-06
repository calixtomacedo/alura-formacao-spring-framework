package br.com.cmdev.javaservletii.web.action;

import java.io.IOException;

import br.com.cmdev.javaservletii.web.model.DataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaDelete implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		DataBase db = new DataBase();
		db.delete(id);
		
		return "redirect:controller?action=empresaList";
	}

}
