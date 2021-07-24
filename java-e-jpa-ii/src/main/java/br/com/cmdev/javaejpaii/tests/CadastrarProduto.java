package br.com.cmdev.javaejpaii.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.dao.ProdutoDAO;
import br.com.cmdev.javaejpaii.model.Categoria;
import br.com.cmdev.javaejpaii.model.Produto;
import br.com.cmdev.javaejpaii.utils.JPAUtil;

public class CadastrarProduto {

	public static void main(String[] args) {

		Categoria categoria = new Categoria("BICICLETA");
		
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setNome("EPIC S-WORKS");
		produto.setDescricao("SPECIALIZED TARMAC S-WORKS 2022 - M");
		produto.setDataCadastro(LocalDateTime.now());
		produto.setPreco(new BigDecimal("99000.00"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		produtoDAO.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}
	
}
