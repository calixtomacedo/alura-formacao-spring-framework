package cmdev.alura.java.jdbc.repository.aula05;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		
		for (int i = 0; i < 15; i++) {
			factory.getConnection();
			System.out.println("Conexão de número: "+i);
		}
	}

}
