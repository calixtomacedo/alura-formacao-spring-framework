package br.com.cmdev.javaservletii.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public interface EmpresaAction {

	public String execute(HttpServletRequest request) throws ServletException, IOException;

}
