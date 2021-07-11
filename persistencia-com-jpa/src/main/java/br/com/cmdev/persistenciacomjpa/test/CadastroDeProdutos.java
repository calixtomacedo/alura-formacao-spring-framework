package br.com.cmdev.persistenciacomjpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.ProdutoDAO;
import br.com.cmdev.persistenciacomjpa.model.Categoria;
import br.com.cmdev.persistenciacomjpa.model.Produto;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;

public class CadastroDeProdutos {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setId(61L);
		
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setNome("EPIC S-WORKS");
		produto.setDescricao("BICICLETA SPECIALIZED EPIC FULL S WORKS 2021 - M");
		produto.setDataCadastro(LocalDateTime.now());
		produto.setPreco(new BigDecimal("62000.00"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		produtoDAO.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}

}
