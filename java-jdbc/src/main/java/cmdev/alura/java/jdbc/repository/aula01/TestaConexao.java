package cmdev.alura.java.jdbc.repository.aula01;

import java.sql.Connection;

import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws Exception {
		
		
		
		System.out.println("ABRINDO A CONEXÃO");
		Connection connection = new ConnectionFactory().getConnection();
		
		String status; 
		if(connection.isClosed()) {
			status = "Fechada";
		}else {
			status = "Aberta";
		}
		
		System.out.println(connection.getMetaData().getDatabaseProductName()+" >> "+connection.getSchema()+" >> Conexão "+ status);
		
		System.out.println("FECHANDO A CONEXÃO");
		connection.close();
	}

}
