package br.com.cmdev.javaejpa.test;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.CategoriaDAO;
import br.com.cmdev.javaejpa.model.Categoria;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class CadastroDeCategorias {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setDescricao("CELULAR");
		categoria.setDataCadastro(LocalDateTime.now());
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(categoria);
		
		em.getTransaction().commit();
		em.close();
	}

}
