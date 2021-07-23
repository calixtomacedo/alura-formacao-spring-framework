package br.com.cmdev.javaejpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.ClienteDAO;
import br.com.cmdev.javaejpa.dao.PedidoDAO;
import br.com.cmdev.javaejpa.dao.ProdutoDAO;
import br.com.cmdev.javaejpa.model.Cliente;
import br.com.cmdev.javaejpa.model.ItemPedido;
import br.com.cmdev.javaejpa.model.Pedido;
import br.com.cmdev.javaejpa.model.Produto;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);
		Cliente cliente = cadastrarCliente(entityManager, clienteDAO);
		
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		Produto produto = produtoDAO.buscarPorId(101L);
		
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataPedido(LocalDateTime.now());
		
		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		item.setPedido(pedido);
		item.setQuantidade(10);
		item.setPrecoUnitario(produto.getPreco());
		
		pedido.setValorTotal(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
		pedido.setItens(Arrays.asList(item));
		
		entityManager.getTransaction().begin();
		pedidoDAO.cadastrar(pedido);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	private static Cliente cadastrarCliente(EntityManager entityManager, ClienteDAO dao) {
		Cliente cliente = new Cliente();
		cliente.setNome("Carlos Eduardo Macedo");
		cliente.setCpf("123.654.789-10");
		cliente.setDataCadastro(LocalDateTime.now());
		dao.cadastrar(cliente);
		return cliente;
	}

}
