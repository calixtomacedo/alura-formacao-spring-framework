package br.com.cmdev.persistenciacomjpa.test;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.PedidoDAO;
import br.com.cmdev.persistenciacomjpa.model.Pedido;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;

public class ConsultaPedidoPerformaceConsultas {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
	
		PedidoDAO dao = new PedidoDAO(entityManager);
		
		Pedido pedido = dao.buscarPedidoComCliente(21L);
		
		entityManager.close();

		System.out.println(pedido.getCliente().getNome());
		
	}
}
