package br.com.cmdev.ws.client;

import org.apache.http.client.fluent.Request;

public class ClientWebService {

	public static void main(String[] args) throws Exception {
		String conteudo = Request.Post("http://localhost:8081/java-servlet-ii-web/empresas")
				.addHeader("Accept", "application/json")
				.execute()
				.returnContent()
				.asString();

		System.out.println(conteudo);
	}

}
