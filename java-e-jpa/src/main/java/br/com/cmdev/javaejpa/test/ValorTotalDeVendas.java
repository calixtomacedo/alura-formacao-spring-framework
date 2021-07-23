package br.com.cmdev.javaejpa.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.PedidoDAO;
import br.com.cmdev.javaejpa.util.JPAUtil;
import br.com.cmdev.javaejpa.util.Util;

public class ValorTotalDeVendas {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);

		BigDecimal valorTotalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("O Total vendido é: " + Util.formataMoeda(valorTotalVendido));
	}

}
