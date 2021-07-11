package br.com.cmdev.persistenciacomjpa.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.cmdev.persistenciacomjpa.model.Produto;

public class ProdutoDAO {
	
	private EntityManager entityManager;

	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}

	public List<Produto> listar() {
		String jpql = "SELECT p FROM Produto p";
		return this.entityManager.createQuery(jpql, Produto.class).getResultList();
	}
	
	public void atualizar(Produto produto) {
		this.entityManager.merge(produto);
	}

	public void deletar(Produto produto) {
		this.entityManager.remove(produto);
	}

	public Produto buscarPorId(Long id) {
		return this.entityManager.find(Produto.class, id);
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome LIKE :pNome";
		return this.entityManager.createQuery(jpql, Produto.class).setParameter("pNome", nome).getResultList();
	}
	
	public List<Produto> buscarPorLike(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE UPPER(p.nome) LIKE UPPER(:pNome)";
		return this.entityManager.createQuery(jpql, Produto.class).setParameter("pNome", "%"+nome+"%").getResultList();
	}
	
	public List<Produto> buscarPorCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.descricao = :pDescricao";
		return this.entityManager.createQuery(jpql, Produto.class).setParameter("pDescricao", nome).getResultList();
	}
	
	public List<Produto> buscarPorCategoriaNamedQuery(String nome) {
		return this.entityManager.createNamedQuery("Produto.buscaPorCategoria", Produto.class).setParameter("pDescricao", nome).getResultList();
	}
	
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :pNome";
		return this.entityManager.createQuery(jpql, BigDecimal.class).setParameter("pNome", nome).getSingleResult();
	}
	
	public List<Produto> buscarProdutoComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		Predicate filtros = builder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if (preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if (dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return entityManager.createQuery(query).getResultList();
	}
	
}
