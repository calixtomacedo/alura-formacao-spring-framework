package br.com.cmdev.javaservletii.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UsuarioLogout implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "redirect:controller?action=loginForm";
	}

}
