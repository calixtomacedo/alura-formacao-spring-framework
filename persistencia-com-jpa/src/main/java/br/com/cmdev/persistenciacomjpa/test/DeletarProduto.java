package br.com.cmdev.persistenciacomjpa.test;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.PedidoDAO;
import br.com.cmdev.persistenciacomjpa.model.Pedido;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;

public class DeletarProduto {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO pedidosDAO = new PedidoDAO(em);
		
		Pedido pedido = pedidosDAO.buscarPorId(22L);
		
		em.getTransaction().begin();
		pedidosDAO.deletar(pedido);
		em.getTransaction().commit();
		em.close();
	}

}
