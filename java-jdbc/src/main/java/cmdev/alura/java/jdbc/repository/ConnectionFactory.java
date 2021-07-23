package cmdev.alura.java.jdbc.repository;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	//private Connection connection;

	private DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		//pooledDataSource.setJdbcUrl(getUrlConnectionOracle());
		pooledDataSource.setJdbcUrl(getUrlConnectionMySQL());
		pooledDataSource.setUser("alura");
		//pooledDataSource.setPassword("access@Alura");
		pooledDataSource.setPassword("senha01@Alura");
		pooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = pooledDataSource;
	}

	private String getUrlConnectionMySQL() {
		String url = "jdbc:mysql://";
		String serverName = "192.168.0.18:3306/";
		String dataBase = "aluradb";
		//String param = "?useTimezone=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&relaxAutoCommit=true&autoReconnect=true&failOverReadOnly=false&interactiveClient=true";
		String param = "?useUnicode=true&characterEncoding=UTF-8&relaxAutoCommit=true&autoReconnect=true&failOverReadOnly=false&interactiveClient=true";
		StringBuilder urlConnection = new StringBuilder(url).append(serverName).append(dataBase).append(param);
		return urlConnection.toString();
	}
	
	@SuppressWarnings("unused")
	private String getUrlConnectionOracle() {
		String url = "jdbc:oracle:thin:@//";
		String serverName = "192.168.0.43:1521/";
		String dataBase = "XEPDB1";
		StringBuilder urlConnection = new StringBuilder(url).append(serverName).append(dataBase);
		return urlConnection.toString();
	}
	
	public Connection getConnection() throws Exception {
		return this.dataSource.getConnection();
	}

	/*
	public Connection getConnection() throws Exception {

		// MySql
		// String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://";
		String serverName = "localhost:3306/";
		String dataBase = "loja_virtual?";
		String timezone = "useTimezone=true&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8&useSSL=false&";
		String autoCommit = "relaxAutoCommit=true";
		String userName = "alura";
		String password = "access@Alura";

		StringBuilder urlConnection = new StringBuilder(url).append(serverName).append(dataBase).append(timezone).append(autoCommit);

		try {
			this.connection = DriverManager.getConnection(urlConnection.toString(), userName, password);
		} catch (SQLException e) {
			throw new Exception("Erro ao criar a conexão: " + e);
		}
		return this.connection;
	}
	*/

}
