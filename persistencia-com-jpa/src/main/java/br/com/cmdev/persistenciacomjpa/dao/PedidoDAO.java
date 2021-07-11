package br.com.cmdev.persistenciacomjpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.model.Pedido;
import br.com.cmdev.persistenciacomjpa.model.vo.RelatorioDeVendasVO;

public class PedidoDAO {

	private EntityManager entityManager;

	public PedidoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}

	public List<Pedido> listar() {
		String jpql = "SELECT p FROM Pedido p";
		return this.entityManager.createQuery(jpql, Pedido.class).getResultList();
	}

	public void atualizar(Pedido pedido) {
		this.entityManager.merge(pedido);
	}

	public void deletar(Pedido pedido) {
		this.entityManager.remove(pedido);
	}

	public Pedido buscarPorId(Long id) {
		return this.entityManager.find(Pedido.class, id);
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	/*
	 * public List<Object[]> relatorioDeVendas() { StringBuilder jpql = new StringBuilder(); jpql.append("SELECT produto.nome, SUM(item.quantidade), MAX(pedido.dataPedido) "); jpql.append("FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto "); jpql.append("GROUP BY produto.nome, item.quantidade "); jpql.append("ORDER BY item.quantidade DESC"); return
	 * entityManager.createQuery(jpql.toString(), Object[].class).getResultList(); }
	 */

	public List<RelatorioDeVendasVO> relatorioDeVendas() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT new br.com.cmdev.persistenciacomjpa.model.vo.RelatorioDeVendasVO (produto.nome, SUM(item.quantidade), MAX(pedido.dataPedido)) ");
		jpql.append("FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto ");
		jpql.append("GROUP BY produto.nome, item.quantidade ");
		jpql.append("ORDER BY item.quantidade DESC");
		return entityManager.createQuery(jpql.toString(), RelatorioDeVendasVO.class).getResultList();
	}

	public Pedido buscarPedidoComCliente(Long id) {
		return this.entityManager.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :pId", Pedido.class).setParameter("pId", id).getSingleResult();
	}

}
