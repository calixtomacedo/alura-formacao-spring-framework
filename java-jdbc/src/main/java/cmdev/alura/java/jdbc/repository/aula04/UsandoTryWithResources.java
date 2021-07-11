package cmdev.alura.java.jdbc.repository.aula04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class UsandoTryWithResources {

	public static void main(String[] args) throws Exception {

		try (Connection connection = new ConnectionFactory().getConnection()) {
			connection.setAutoCommit(false);
			String sql = "INSERT INTO TB_PRODUTO(IDCATEGORIA, NMPRODUTO, DSPRODUTO, DTCRIACAO, FLATIVO) VALUES(?, ?, ?, SYSDATE, ?)";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql, new int[] {1})) {
				adicionarItens(41, "TECLADO", "TECLADO WIRELESS KEYBOARD 1850", "S", prepareStatement);
				adicionarItens(41 ,"MONITOR", "MONITOR DELL DE 23.8 P2421D", "N", prepareStatement);

				connection.commit();

			} catch (Exception e) {
				System.out.println("ROLLBACK EXECUTADO COM SUCESSO DEVIDO O SEGUINTE ERRO: " + e);
				connection.rollback();
			}
		}
	}

	private static void adicionarItens(Integer idCategoria, String nome, String descricao, String flAtivo, PreparedStatement prepareStatement) throws SQLException {
		prepareStatement.setInt(1, idCategoria);
		prepareStatement.setString(2, nome);
		prepareStatement.setString(3, descricao);
		prepareStatement.setString(4, flAtivo);
		/*
		 * if(nome.equalsIgnoreCase("monitor")) { throw new RuntimeException("Não foi possível gravar o "+nome); }
		 */
		prepareStatement.execute();

		Integer id = null;
		try (ResultSet resultSet = prepareStatement.getGeneratedKeys()) {
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		}
		System.out.println("ID criado na base de dados: " + id);
	}
}
