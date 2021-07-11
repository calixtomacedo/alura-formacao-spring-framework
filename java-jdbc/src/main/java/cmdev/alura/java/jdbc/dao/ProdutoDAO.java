package cmdev.alura.java.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cmdev.alura.java.jdbc.model.Categoria;
import cmdev.alura.java.jdbc.model.Produto;
import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class ProdutoDAO {

	private static ProdutoDAO instance;

	private Connection connection;

	public static ProdutoDAO getInstance() throws Exception {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	public ProdutoDAO() throws Exception {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvar(Produto produto) throws SQLException {
		//String sql = "INSERT INTO TB_PRODUTO(IDCATEGORIA, NMPRODUTO, DSPRODUTO, DTCRIACAO, FLATIVO) VALUES(?, ?, ?, SYSDATE, ?)";
		String sql = "INSERT INTO TB_PRODUTO(NMPRODUTO, DSPRODUTO, DTCRIACAO, FLATIVO) VALUES(?, ?, ?, ?)";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql, new int[] {1})) {
			
			//prepareStatement.setInt(1, produto.getCategoria().getIdCategoria());
			prepareStatement.setString(1, produto.getNmProduto());
			prepareStatement.setString(2, produto.getDsProduto());
			prepareStatement.setTimestamp(3, Timestamp.valueOf(produto.getDtCriacao()));
			//prepareStatement.setDate(3, new Date(produto.getDtCriacao().getTime()));
			prepareStatement.setString(4, produto.getFlAtivo());
			
			prepareStatement.execute();

			try (ResultSet resultSet = prepareStatement.getGeneratedKeys()) {
				while (resultSet.next()) {
					produto.setIdProduto(resultSet.getInt(1));
				}
			}
		}
	}
	

	public List<Produto> listar() throws SQLException {
		List<Produto> produtoList;
		String sqlQuery = "SELECT * FROM TB_PRODUTO";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sqlQuery)) {
			prepareStatement.execute();
			Produto produto;
			try (ResultSet resultSet = prepareStatement.getResultSet()) {
				produtoList = new ArrayList<Produto>();
				while (resultSet.next()) {
					produto = new Produto();
					Categoria categoria = new Categoria();
					//categoria.setIdCategoria(resultSet.getInt("IDCATEGORIA"));
					produto.setCategoria(categoria);
					produto.setIdProduto(resultSet.getInt("IDPRODUTO"));
					produto.setNmProduto(resultSet.getString("NMPRODUTO"));
					produto.setDsProduto(resultSet.getString("DSPRODUTO"));
					produto.setDtCriacao(resultSet.getObject("DTCRIACAO", LocalDateTime.class));
					produto.setDtAlteracao(resultSet.getObject("DTALTERACAO", LocalDateTime.class));
					produto.setFlAtivo(resultSet.getString("FLATIVO"));
					produtoList.add(produto);
				}
			}
		}
		return produtoList;
	}
	
	public Produto pesquisaPorId(Integer idProduto) throws SQLException {
		Produto produto = null;
		String sqlQuery = "SELECT * FROM TB_PRODUTO WHERE IDPRODUTO = ?";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sqlQuery)) {
			prepareStatement.setInt(1, idProduto);
			prepareStatement.execute();
			try (ResultSet resultSet = prepareStatement.getResultSet()) {
				while (resultSet.next()) {
					produto = new Produto();
					Categoria categoria = new Categoria();
					categoria.setIdCategoria(resultSet.getInt("IDCATEGORIA"));
					produto.setCategoria(categoria );
					produto.setIdProduto(resultSet.getInt("IDPRODUTO"));
					produto.setNmProduto(resultSet.getString("NMPRODUTO"));
					produto.setDsProduto(resultSet.getString("DSPRODUTO"));
					produto.setDtCriacao(resultSet.getObject("DTCRIACAO", LocalDateTime.class));
					produto.setDtAlteracao(resultSet.getObject("DTALTERACAO", LocalDateTime.class));
					produto.setFlAtivo(resultSet.getString("FLATIVO"));
				}
			}
		}
		return produto;
	}

	public void remover(Produto produto) throws SQLException {
		String sql = "DELETE FROM TB_PRODUTO WHERE IDPRODUTO = ?";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			prepareStatement.setInt(1, produto.getIdProduto());
			prepareStatement.execute();
			Integer updateCount = prepareStatement.getUpdateCount();
			System.out.println("\n Linhas apagadas: "+updateCount+"\n");
		}
	}

	public void alterar(Produto produto) throws SQLException {
		String sql = "UPDATE TB_PRODUTO SET IDCATEGORIA = ?, NMPRODUTO = ?, DSPRODUTO = ?, DTALTERACAO = SYSDATE, FLATIVO = ? WHERE IDPRODUTO = ?";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			prepareStatement.setInt(1, produto.getCategoria().getIdCategoria());
			prepareStatement.setString(2, produto.getNmProduto());
			prepareStatement.setString(3, produto.getDsProduto());
			prepareStatement.setString(4, produto.getFlAtivo());
			prepareStatement.setInt(5, produto.getIdProduto());
			prepareStatement.executeUpdate();
			Integer updateCount = prepareStatement.getUpdateCount();
			System.out.println("\n Linhas alteradas: "+updateCount+"\n");
		}
	}

	public List<Produto> buscar(Categoria categoria) throws SQLException {
		List<Produto> produtoList;
		String sqlQuery = "SELECT * FROM TB_PRODUTO WHERE IDCATEGORIA = ?";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sqlQuery)) {
			prepareStatement.setInt(1, categoria.getIdCategoria());
			prepareStatement.execute();
			try (ResultSet resultSet = prepareStatement.getResultSet()) {
				produtoList = new ArrayList<Produto>();
				while (resultSet.next()) {
					Produto produto = new Produto();
					Categoria cat = new Categoria();
					cat.setIdCategoria(resultSet.getInt("IDCATEGORIA"));
					produto.setCategoria(cat);
					produto.setIdProduto(resultSet.getInt("IDPRODUTO"));
					produto.setNmProduto(resultSet.getString("NMPRODUTO"));
					produto.setDsProduto(resultSet.getString("DSPRODUTO"));
					produto.setDtCriacao(resultSet.getObject("DTCRIACAO", LocalDateTime.class));
					produto.setDtAlteracao(resultSet.getObject("DTALTERACAO", LocalDateTime.class));
					produto.setFlAtivo(resultSet.getString("FLATIVO"));
					produtoList.add(produto);
				}
			}
		}
		return produtoList;
	}

}
