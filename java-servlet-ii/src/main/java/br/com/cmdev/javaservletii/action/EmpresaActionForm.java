package br.com.cmdev.javaservletii.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class EmpresaActionForm implements EmpresaAction {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "forward:/pages/empresa-form.jsp";
	}

}
