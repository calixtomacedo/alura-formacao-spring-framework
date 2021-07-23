package br.com.cmdev.javaservletii.web.services;

import java.io.IOException;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.javaservletii.web.model.DataBase;
import br.com.cmdev.javaservletii.web.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/empresas/xml")
public class EmpresasXmlService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Empresa> empresas = new DataBase().getEmpresas();

		XStream xStream = new XStream();
		xStream.alias("empresa", Empresa.class);
		String xml = xStream.toXML(empresas);

		response.setContentType("application/xml");
		response.getWriter().print(xml);
	}

}
