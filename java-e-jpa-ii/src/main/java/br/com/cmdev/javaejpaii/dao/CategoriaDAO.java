package br.com.cmdev.javaejpaii.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpaii.model.Categoria;

public class CategoriaDAO {
	
	private EntityManager entityManager;

	public CategoriaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Categoria categoria) {
		this.entityManager.persist(categoria);
	}
	
	public Categoria buscarPorId(Long id) {
		return this.entityManager.find(Categoria.class, id);
	}

	public List<Categoria> listar() {
		String jpql = "SELECT c FROM Categoria c";
		return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
	}

	public void atualizar(Categoria categoria) {
		this.entityManager.merge(categoria);
	}

	public void deletar(Categoria categoria) {
		this.entityManager.remove(categoria);
	}
}
