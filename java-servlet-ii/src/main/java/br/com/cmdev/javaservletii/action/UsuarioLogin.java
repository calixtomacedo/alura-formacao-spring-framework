package br.com.cmdev.javaservletii.action;

import java.io.IOException;

import br.com.cmdev.javaservletii.model.DataBase;
import br.com.cmdev.javaservletii.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class UsuarioLogin implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		DataBase db = new DataBase();
		
		Usuario user = db.usarioLogin(login, senha);
		
		if(user == null) {
			request.setAttribute("msgLogin", "Usuário ou senha inválido. Tente novamente");
			return "forward:login-form.jsp";
		}
		
		request.getSession().setAttribute("user", user);
		
		return "redirect:controller?action=empresaList";
	}

}
