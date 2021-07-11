package br.com.cmdev.persistenciacomjpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.ClienteDAO;
import br.com.cmdev.persistenciacomjpa.dao.PedidoDAO;
import br.com.cmdev.persistenciacomjpa.dao.ProdutoDAO;
import br.com.cmdev.persistenciacomjpa.model.Cliente;
import br.com.cmdev.persistenciacomjpa.model.ItemPedido;
import br.com.cmdev.persistenciacomjpa.model.Pedido;
import br.com.cmdev.persistenciacomjpa.model.Produto;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;

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
