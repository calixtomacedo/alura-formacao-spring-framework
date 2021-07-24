package br.com.cmdev.javaejpaii.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.PedidoDAO;
import br.com.cmdev.javaejpaii.utils.JPAUtil;
import br.com.cmdev.javaejpaii.utils.Util;

public class ValorTotalDeVendas {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);

		BigDecimal valorTotalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("O Total vendido é: " + Util.formataMoeda(valorTotalVendido));
	}

}
