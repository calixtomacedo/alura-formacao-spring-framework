package br.com.cmdev.javaejpa.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.PedidoDAO;
import br.com.cmdev.javaejpa.model.vo.RelatorioDeVendasVO;
import br.com.cmdev.javaejpa.util.JPAUtil;
import br.com.cmdev.javaejpa.util.Util;

public class RelatorioDeVendas {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		
		/*
		List<Object[]> relatorio = pedidoDAO.relatorioDeVendas();
		for (Object[] rel : relatorio) {
			System.out.println("Produto: " + rel[0]+", Quantidade Vendida: "+rel[1]+" Última venda em: "+rel[2]);
		}
		 */		
		
		List<RelatorioDeVendasVO> relatorioList = pedidoDAO.relatorioDeVendas();
		relatorioList.forEach(rel -> System.out.println("Produto: " + rel.getNomeProduto()+" - Quantidade Vendida: "+rel.getQuantidadeVendida()+" - Última venda em: "+Util.formatDataComHora(rel.getDataUltimaVenda())));
		
	}

}
