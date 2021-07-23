package br.com.cmdev.javaejpa.test;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.CategoriaDAO;
import br.com.cmdev.javaejpa.model.Categoria;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class DeletarCategoria {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Categoria categoria = em.find(Categoria.class, 41L);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		em.getTransaction().begin();
		categoriaDAO.deletar(categoria);
		em.getTransaction().commit();
		em.close();
	}

}
