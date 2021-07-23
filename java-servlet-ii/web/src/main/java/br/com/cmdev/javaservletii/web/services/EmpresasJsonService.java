package br.com.cmdev.javaservletii.web.services;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import br.com.cmdev.javaservletii.web.model.DataBase;
import br.com.cmdev.javaservletii.web.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/empresas/json")
public class EmpresasJsonService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new DataBase().getEmpresas();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(empresas);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}
	
}
