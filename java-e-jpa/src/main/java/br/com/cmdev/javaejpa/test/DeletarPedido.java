package br.com.cmdev.javaejpa.test;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.ProdutoDAO;
import br.com.cmdev.javaejpa.model.Produto;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class DeletarPedido {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Produto produto = produtoDAO.buscarPorId(83L);
		
		em.getTransaction().begin();
		produtoDAO.deletar(produto);
		em.getTransaction().commit();
		em.close();
	}

}
