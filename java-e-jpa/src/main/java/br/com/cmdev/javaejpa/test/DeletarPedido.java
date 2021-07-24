package br.com.cmdev.javaejpa.test;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.PedidoDAO;
import br.com.cmdev.javaejpa.model.Pedido;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class DeletarPedido {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO pedidosDAO = new PedidoDAO(em);
		
		Pedido pedido = pedidosDAO.buscarPorId(2L);
		
		em.getTransaction().begin();
		pedidosDAO.deletar(pedido);
		em.getTransaction().commit();
		em.close();
	}

}
