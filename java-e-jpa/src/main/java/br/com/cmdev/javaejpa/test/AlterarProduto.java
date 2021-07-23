package br.com.cmdev.javaejpa.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.ProdutoDAO;
import br.com.cmdev.javaejpa.model.Categoria;
import br.com.cmdev.javaejpa.model.Produto;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class AlterarProduto {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Categoria categoria = new Categoria();
		categoria.setId(4L);
		
		Produto produto = produtoDAO.buscarPorId(43L);
		
		produto.setCategoria(categoria);
		produto.setNome("O Livro de Eli");
		produto.setDescricao("O Livro de Eli é um filme norte-americano do gênero ação e ficção científica de 2010, dirigido pelos irmãos Albert e Allen Hughes e estrelado por Denzel Washington, Gary Oldman, Mila Kunis e Jennifer Beals.");
		produto.setDataCadastro(produto.getDataCadastro());
		produto.setPreco(new BigDecimal(79.90));
		
		//CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		produtoDAO.atualizar(produto);
		
		em.getTransaction().commit();
		em.close();
	}

}
