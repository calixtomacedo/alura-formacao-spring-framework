package br.com.cmdev.javaejpaii.tests;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.ProdutoDAO;
import br.com.cmdev.javaejpaii.model.Produto;
import br.com.cmdev.javaejpaii.utils.JPAUtil;

public class ListarProdutos {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		
		List<Produto> produtos = new ProdutoDAO(entityManager).listar();
		produtos.forEach(prod -> {
			System.out.println(prod);
		});
	}

}
