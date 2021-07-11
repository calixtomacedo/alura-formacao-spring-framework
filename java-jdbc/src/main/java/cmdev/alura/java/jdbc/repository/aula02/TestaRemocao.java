package cmdev.alura.java.jdbc.repository.aula02;

import java.sql.Connection;
import java.sql.Statement;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws Exception {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		Statement statement = connection.createStatement();
		
		statement.execute("DELETE FROM TB_PRODUTO WHERE IDPRODUTO = 91");

		Integer updateCount = statement.getUpdateCount();
		
		System.out.println("Total de registro alterados: "+updateCount);
	}
}
