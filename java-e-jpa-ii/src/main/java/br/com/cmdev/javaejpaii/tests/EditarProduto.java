package br.com.cmdev.javaejpaii.tests;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.ProdutoDAO;
import br.com.cmdev.javaejpaii.model.Produto;
import br.com.cmdev.javaejpaii.utils.JPAUtil;

public class EditarProduto {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(entityManager);
		
		Produto produto = dao.buscarPorId(6L);
		produto.setNome("TARMAC S-WORKS");
		
		entityManager.getTransaction().begin();
		dao.atualizar(produto);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
