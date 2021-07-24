package br.com.cmdev.javaejpaii.tests;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.PedidoDAO;
import br.com.cmdev.javaejpaii.model.RelatorioDeVendasVO;
import br.com.cmdev.javaejpaii.utils.JPAUtil;
import br.com.cmdev.javaejpaii.utils.Util;

public class RelatorioDeVendas {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		
		List<RelatorioDeVendasVO> relatorioList = pedidoDAO.relatorioDeVendas();
		relatorioList.forEach(rel -> System.out.println("Produto: " + rel.getNomeProduto()+" - Quantidade Vendida: "+rel.getQuantidadeVendida()+" - Última venda em: "+Util.formatDataComHora(rel.getDataUltimaVenda())));
		
	}

}
