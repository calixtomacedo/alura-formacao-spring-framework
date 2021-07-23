package br.com.cmdev.javaservletii.web.services;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.cmdev.javaservletii.web.model.DataBase;
import br.com.cmdev.javaservletii.web.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/empresas")
public class EmpresasService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new DataBase().getEmpresas();
		
		String header = request.getHeader("Accept");
		
		if(header.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		}else if (header.contains("xml")) {
			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);

			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':' no content'}");
		}
	}

}
