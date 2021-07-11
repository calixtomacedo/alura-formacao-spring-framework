package cmdev.alura.java.jdbc.repository.aula02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws Exception {

		Connection connection = new ConnectionFactory().getConnection();

		Statement statement = connection.createStatement();

		statement.execute("SELECT IDPRODUTO, NMPRODUTO, DSPRODUTO, DTCRIACAO, DTALTERACAO, FLATIVO FROM TB_PRODUTO");

		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {
			Integer id = resultSet.getInt("IDPRODUTO");
			String nome = resultSet.getString("NMPRODUTO");
			String decricao = resultSet.getString("DSPRODUTO");
			String dtCriacao = resultSet.getString("DTCRIACAO");
			String dtAlteracao = resultSet.getString("DTALTERACAO");
			String flAtivo = resultSet.getString("FLATIVO");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(decricao);
			System.out.println(dtCriacao);
			System.out.println(dtAlteracao);
			System.out.println(flAtivo);
		}
		
		connection.close();
	}

}
