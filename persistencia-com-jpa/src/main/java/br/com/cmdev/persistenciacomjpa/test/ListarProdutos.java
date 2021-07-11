package br.com.cmdev.persistenciacomjpa.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.ProdutoDAO;
import br.com.cmdev.persistenciacomjpa.model.Produto;
import br.com.cmdev.persistenciacomjpa.util.Util;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;

public class ListarProdutos {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		
		ProdutoDAO dao = new ProdutoDAO(entityManager);

		Produto p = dao.buscarPorId(101L);
		System.out.println("Produto id: "+p.getId()+", Nome: "+p.getNome()+", Descricao: "+p.getCategoria().getDescricao()+", Preço: "+p.getPreco()+", Data Cadastro: "+Util.formatDataComHora(p.getDataCadastro()));
		
		System.out.println("\n");
		List<Produto> produtoList = dao.buscarPorNome("TARMAC S-WORKS");
		produtoList.forEach(pd -> {
			System.out.println("Produto id: "+pd.getId()+", Nome: "+pd.getNome()+", Descricao: "+pd.getCategoria().getDescricao()+", Preço: "+pd.getPreco()+", Data Cadastro: "+Util.formatDataComHora(pd.getDataCadastro()));
		});
		
		System.out.println("\n");
		List<Produto> produtoss = dao.buscarPorLike("ro");
		produtoss.forEach(pd -> {
			System.out.println("Produto id: "+pd.getId()+", Nome: "+pd.getNome()+", Descricao: "+pd.getCategoria().getDescricao()+", Preço: "+pd.getPreco()+", Data Cadastro: "+Util.formatDataComHora(pd.getDataCadastro()));
		});
		
		List<Produto> produtos = dao.listar();
		System.out.println("\n");
		
		produtos.forEach(pd -> {
			System.out.println("Produto id: "+pd.getId()+", Nome: "+pd.getNome()+", Descricao: "+pd.getCategoria().getDescricao()+", Preço: "+pd.getPreco()+", Data Cadastro: "+Util.formatDataComHora(pd.getDataCadastro()));
		});
		
		System.out.println("\n");
		List<Produto> produtoCat = dao.buscarPorCategoria("CELULARES");
		produtoCat.forEach(pd -> {
			System.out.println("Produto id: "+pd.getId()+", Nome: "+pd.getNome()+", Descricao: "+pd.getCategoria().getDescricao()+", Preço: "+pd.getPreco()+", Data Cadastro: "+Util.formatDataComHora(pd.getDataCadastro()));
		});
		
		System.out.println("\n");
		List<Produto> produtoC = dao.buscarPorCategoriaNamedQuery("BICICLETAS");
		produtoC.forEach(pd -> {
			System.out.println("Produto id: "+pd.getId()+", Nome: "+pd.getNome()+", Descricao: "+pd.getCategoria().getDescricao()+", Preço: "+pd.getPreco()+", Data Cadastro: "+Util.formatDataComHora(pd.getDataCadastro()));
		});

		System.out.println("\n");
		BigDecimal preco = dao.buscarPrecoDoProdutoComNome("TARMAC S-WORKS");
		System.out.println("Preço: "+preco);

	}
}
