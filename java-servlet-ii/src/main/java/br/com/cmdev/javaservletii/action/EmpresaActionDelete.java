package br.com.cmdev.javaservletii.action;

import java.io.IOException;

import br.com.cmdev.javaservletii.model.DataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaActionDelete implements EmpresaAction {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		DataBase db = new DataBase();
		db.delete(id);
		
		return "redirect:empresa?action=list";
	}

}
