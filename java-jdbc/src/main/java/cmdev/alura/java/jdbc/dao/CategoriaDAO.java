package cmdev.alura.java.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cmdev.alura.java.jdbc.model.Categoria;
import cmdev.alura.java.jdbc.model.Produto;
import cmdev.alura.java.jdbc.repository.ConnectionFactory;

public class CategoriaDAO {

	private static CategoriaDAO instance;

	private Connection connection;

	public static CategoriaDAO getInstance() throws Exception {
		if (instance == null) {
			instance = new CategoriaDAO();
		}
		return instance;
	}

	public CategoriaDAO() throws Exception {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvar(Categoria categoria) throws SQLException {
		String sql = "INSERT INTO TB_CATEGORIA(NMCATEGORIA, DTCRIACAO, FLATIVO) VALUES(?, SYSDATE, ?)";
		//try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sql, new String[] {"IDCATEGORIA"})) {
			prepareStatement.setString(1, categoria.getNmCategoria());
			prepareStatement.setString(2, categoria.getFlAtivo());
			prepareStatement.execute();
			try (ResultSet keys = prepareStatement.getGeneratedKeys()) {
				while (keys.next()) {
					categoria.setIdCategoria(keys.getInt(1));
				}
			}
		}
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categoriaList;
		String sqlQuery = "SELECT * FROM TB_CATEGORIA";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sqlQuery)) {
			prepareStatement.execute();
			try (ResultSet resultSet = prepareStatement.getResultSet()) {
				categoriaList = new ArrayList<Categoria>();
				while (resultSet.next()) {
					Categoria categoria = new Categoria();
					categoria.setIdCategoria(resultSet.getInt("IDCATEGORIA"));
					categoria.setNmCategoria(resultSet.getString("NMCATEGORIA"));
					categoria.setDtCriacao(resultSet.getTimestamp("DTCRIACAO"));
					categoria.setDtAlteracao(resultSet.getTimestamp("DTALTERACAO"));
					categoria.setFlAtivo(resultSet.getString("FLATIVO"));
					categoriaList.add(categoria);
				}
			}
		}
		return categoriaList;
	}

	public List<Categoria> listarCategoriaProdutos() throws SQLException {
		List<Categoria> categoriaList;
		Categoria nextCateg = null;
		String sqlQuery = "SELECT C.*, P.* FROM TB_CATEGORIA C LEFT JOIN TB_PRODUTO P ON C.IDCATEGORIA = P.IDCATEGORIA";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(sqlQuery)) {
			prepareStatement.execute();
			try (ResultSet resultSet = prepareStatement.getResultSet()) {
				categoriaList = new ArrayList<Categoria>();
				while (resultSet.next()) {
					Categoria categoria = new Categoria();
					categoria.setProdutos(new ArrayList<Produto>());
					Produto produto = new Produto();
					if(nextCateg == null || !nextCateg.getNmCategoria().equalsIgnoreCase(resultSet.getNString("NMCATEGORIA"))) {
						categoria.setIdCategoria(resultSet.getInt("IDCATEGORIA"));
						categoria.setNmCategoria(resultSet.getString("NMCATEGORIA"));
						categoria.setDtCriacao(resultSet.getTimestamp("DTCRIACAO"));
						categoria.setDtAlteracao(resultSet.getTimestamp("DTALTERACAO"));
						categoria.setFlAtivo(resultSet.getString("FLATIVO"));
						categoriaList.add(categoria);
						nextCateg = categoria;
					}
					produto.setIdProduto(resultSet.getInt("IDPRODUTO"));
					produto.setCategoria(categoria);
					produto.setNmProduto(resultSet.getString("NMPRODUTO"));
					produto.setDsProduto(resultSet.getString("DSPRODUTO"));
					produto.setDtCriacao(resultSet.getObject("DTCRIACAO", LocalDateTime.class));
					produto.setDtAlteracao(resultSet.getObject("DTALTERACAO", LocalDateTime.class));
					produto.setFlAtivo(resultSet.getString("FLATIVO"));
					nextCateg.getProdutos().add(produto);
				}
			}
		}
		return categoriaList;
	}
}
