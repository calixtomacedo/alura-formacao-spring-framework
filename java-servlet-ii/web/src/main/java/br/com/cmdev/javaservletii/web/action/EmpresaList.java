package br.com.cmdev.javaservletii.web.action;

import java.io.IOException;
import java.util.List;

import br.com.cmdev.javaservletii.web.model.DataBase;
import br.com.cmdev.javaservletii.web.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaList implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		DataBase db = new DataBase();
		List<Empresa> empresas = db.getEmpresas();

		request.setAttribute("empresas", empresas);

		return "forward:/pages/empresa-list.jsp";
	}

}
