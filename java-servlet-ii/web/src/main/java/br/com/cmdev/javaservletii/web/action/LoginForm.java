package br.com.cmdev.javaservletii.web.action;

import java.io.IOException;

import br.com.cmdev.javaservletii.web.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class LoginForm implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		if(user != null && user.isLogged()) {
			return "forward:pages/menu.jsp";
		}
		return "forward:login-form.jsp";
	}

}
