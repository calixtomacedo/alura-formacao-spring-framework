package cmdev.alura.java.jdbc.repository;

import cmdev.alura.java.jdbc.dao.ContaDAO;
import cmdev.alura.java.jdbc.model.Conta;

public class TestaInserirConta {

	public static void main(String[] args) {

		ContaDAO dao = new ContaDAO();
		Conta conta = new Conta(222L, 123456L, "Calixto Rodrigues Macedo");
		dao.adiciona(conta);
	}

}
