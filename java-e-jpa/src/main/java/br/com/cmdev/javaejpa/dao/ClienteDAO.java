package br.com.cmdev.javaejpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.cmdev.javaejpa.model.Cliente;

public class ClienteDAO {

	private EntityManager entityManager;

	public ClienteDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	public List<Cliente> listar() {
		String jpql = "SELECT c FROM Cliente c";
		return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
	}

	public void atualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	public void deletar(Cliente cliente) {
		this.entityManager.remove(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return this.entityManager.find(Cliente.class, id);
	}

	public List<Cliente> buscarPorNome(String nome) {
		String jpql = "SELECT c FROM Cliente c WHERE c.nome LIKE :pNome";
		return this.entityManager.createQuery(jpql, Cliente.class).setParameter("pNome", nome).getResultList();
	}

	public List<Cliente> buscarPorLike(String nome) {
		String jpql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE UPPER(:pNome)";
		return this.entityManager.createQuery(jpql, Cliente.class).setParameter("pNome", "%" + nome + "%").getResultList();
	}
	
	public List<Cliente> buscarClientes(String nome, String cpf) {
	    String jpql = "SELECT c FROM Cliente c WHERE 1 = 1";
	    if (nome != null && !nome.trim().isEmpty()) {
	        jpql += "AND c.nome = :nome ";
	    }
	    if (cpf != null && !cpf.trim().isEmpty()) {
	        jpql += " AND c.cpf = :cpf ";
	    }
	    TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
	    if (nome != null && !nome.trim().isEmpty()) {
	        query.setParameter("nome", nome);
	    }
	    if (cpf != null && !cpf.trim().isEmpty()) {
	        query.setParameter("cpf", cpf);
	    }
	    return query.getResultList();
	}

}
