package cmdev.alura.java.jdbc.repository.aula02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws Exception {

		Connection connection = new ConnectionFactory().getConnection();

		Statement statement = connection.createStatement();

		//statement.execute("INSERT INTO TB_PRODUTO(IDCATEGORIA, NMPRODUTO, DSPRODUTO, DTCRIACAO, FLATIVO) VALUES(41, 'MOUSE', 'WIRELESS MOBILE 1850', SYSDATE, 'S')", Statement.RETURN_GENERATED_KEYS);
		statement.execute("INSERT INTO TB_PRODUTO(IDCATEGORIA, NMPRODUTO, DSPRODUTO, DTCRIACAO, FLATIVO) VALUES(41, 'MOUSE', 'WIRELESS MOBILE 1850', SYSDATE, 'S')", new String [] {"IDPRODUTO"});

		ResultSet resultSet = statement.getGeneratedKeys();
		Integer id;
		id = resultSet.next() ? resultSet.getInt(1) : 0;
		System.out.println(id);
	}

	
}
