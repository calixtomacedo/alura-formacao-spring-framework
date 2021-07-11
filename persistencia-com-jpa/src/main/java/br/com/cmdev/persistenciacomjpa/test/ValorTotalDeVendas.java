package br.com.cmdev.persistenciacomjpa.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.PedidoDAO;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;
import br.com.cmdev.persistenciacomjpa.util.Util;

public class ValorTotalDeVendas {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);

		BigDecimal valorTotalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("O Total vendido é: " + Util.formataMoeda(valorTotalVendido));
	}

}
