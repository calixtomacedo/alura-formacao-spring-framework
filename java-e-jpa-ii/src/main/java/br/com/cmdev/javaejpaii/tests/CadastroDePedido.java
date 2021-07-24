package br.com.cmdev.javaejpaii.tests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.CategoriaDAO;
import br.com.cmdev.javaejpaii.dao.ClienteDAO;
import br.com.cmdev.javaejpaii.dao.PedidoDAO;
import br.com.cmdev.javaejpaii.dao.ProdutoDAO;
import br.com.cmdev.javaejpaii.model.Categoria;
import br.com.cmdev.javaejpaii.model.Cliente;
import br.com.cmdev.javaejpaii.model.ItemPedido;
import br.com.cmdev.javaejpaii.model.Pedido;
import br.com.cmdev.javaejpaii.model.Produto;
import br.com.cmdev.javaejpaii.model.RelatorioDeVendasVO;
import br.com.cmdev.javaejpaii.utils.JPAUtil;
import br.com.cmdev.javaejpaii.utils.Util;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Produto produto = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		Produto produto3 = produtoDAO.buscarPorId(3l);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(40, pedido, produto2));

		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido2, produto3));
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("O Total vendido é: " + Util.formataMoeda(valorTotalVendido));
		
		
		List<RelatorioDeVendasVO> relatorio = pedidoDAO.relatorioDeVendas();
		relatorio.forEach(System.out::println);
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);
		
		Cliente cliente = new Cliente("Calixto", "123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);
		
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(videogame);
		produtoDAO.cadastrar(macbook);
		
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
