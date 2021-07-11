package cmdev.alura.java.jdbc.repository.aula03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaRemocaoPreparedStatement {
	
public static void main(String[] args) throws Exception {
	
		Integer id = 3;
	
		Connection connection = new ConnectionFactory().getConnection();
		
		String sql = "DELETE FROM TB_PRODUTO WHERE IDPRODUTO = ?";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setInt(1, id);
		
		prepareStatement.execute();

		Integer updateCount = prepareStatement.getUpdateCount();
		
		System.out.println("Total de registro alterados: "+updateCount);
	}

}
