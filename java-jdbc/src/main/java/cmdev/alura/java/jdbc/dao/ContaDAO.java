package cmdev.alura.java.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cmdev.alura.java.jdbc.model.Conta;

public class ContaDAO {
	
	private Connection connection;

	public ContaDAO() {
		try {
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.0.43:1521/XEPDB1", "ALURA", "access@Alura");
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	
	 public void adiciona(Conta conta) {
	        try {
	            String sql = "INSERT INTO ALURA.CONTA(AGENCIA, NUMERO, TITULAR) VALUES (?, ?, ?)";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.setLong(1, conta.getAgencia());
	            ps.setLong(2, conta.getNumero());
	            ps.setString(3, conta.getTitular());

	            ps.execute();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	

}
