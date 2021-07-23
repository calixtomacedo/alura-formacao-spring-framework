package br.com.cmdev.persistenciacomjpa.test;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.cmdev.persistenciacomjpa.dao.CategoriaDAO;
import br.com.cmdev.persistenciacomjpa.model.Categoria;
import br.com.cmdev.persistenciacomjpa.util.JPAUtil;

public class CadastroDeCategorias {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setDescricao("BICICLETAS");
		categoria.setDataCadastro(LocalDateTime.now());
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(categoria);
		
		em.getTransaction().commit();
		em.close();
	}

}
