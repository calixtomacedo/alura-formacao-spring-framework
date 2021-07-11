package cmdev.alura.java.jdbc.repository.aula03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaInsercaoPreparedStatement {
	
	public static void main(String[] args) throws Exception {
		Integer idCategoria = 41;
		String nome = "MOUSE"; 
		String descricao = "WIRELESS MOBILE 1850";
		String flAtivo = "S";
		
		Connection connection = new ConnectionFactory().getConnection();

		String sql = "INSERT INTO TB_PRODUTO(IDCATEGORIA, NMPRODUTO, DSPRODUTO, DTCRIACAO, FLATIVO) VALUES(?, ?, ?, SYSDATE, ?)";

		PreparedStatement prepareStatement = connection.prepareStatement(sql, new int[] {1});
		prepareStatement.setInt(1, idCategoria);
		prepareStatement.setString(2, nome);
		prepareStatement.setString(3, descricao);
		prepareStatement.setString(4, flAtivo);
		prepareStatement.execute();

		ResultSet resultSet = prepareStatement.getGeneratedKeys();
		Integer id = null;
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		
		resultSet.close();
		System.out.println(id);
	}

}
