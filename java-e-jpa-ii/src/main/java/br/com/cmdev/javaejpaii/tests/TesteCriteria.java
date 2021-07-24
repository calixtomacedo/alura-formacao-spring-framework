package br.com.cmdev.javaejpaii.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.CategoriaDAO;
import br.com.cmdev.javaejpaii.dao.ProdutoDAO;
import br.com.cmdev.javaejpaii.model.Categoria;
import br.com.cmdev.javaejpaii.model.Produto;
import br.com.cmdev.javaejpaii.utils.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		List<Produto> produtos = produtoDAO.buscarProdutoComCriteria(null, null, LocalDateTime.now());
		produtos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);

		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(videogame);
		produtoDAO.cadastrar(macbook);

		em.getTransaction().commit();
		em.close();
	}
	
}
