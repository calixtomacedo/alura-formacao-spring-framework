package cmdev.alura.java.jdbc.repository.aula03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaListagemPreparedStatement {
	
	public static void main(String[] args) throws Exception {

		Connection connection = new ConnectionFactory().getConnection();

		String param = "";
		
		String sql = "SELECT IDPRODUTO, NMPRODUTO, DSPRODUTO, DTCRIACAO, DTALTERACAO, FLATIVO FROM TB_PRODUTO WHERE NMPRODUTO LIKE ?";

		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setString(1, "%"+param+"%");
		
		prepareStatement.execute();

		ResultSet resultSet = prepareStatement.getResultSet();

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
		resultSet.close();
		connection.close();
	}

}
