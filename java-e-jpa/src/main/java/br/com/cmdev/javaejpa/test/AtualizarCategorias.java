package br.com.cmdev.javaejpa.test;

import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.CategoriaDAO;
import br.com.cmdev.javaejpa.model.Categoria;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class AtualizarCategorias {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setId(23L);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Categoria findCategoria = em.find(Categoria.class, categoria.getId());
		
		findCategoria.setDescricao("BICICLETAS");
		
		findCategoria.setDataCadastro(LocalDateTime.of(2021, Month.MAY, 30, 23, 35, 07));
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		em.getTransaction().begin();
		categoriaDAO.atualizar(findCategoria);
		em.getTransaction().commit();
		em.close();
	}

}
