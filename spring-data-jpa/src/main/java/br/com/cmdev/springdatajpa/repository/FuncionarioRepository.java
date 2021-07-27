package br.com.cmdev.springdatajpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.cmdev.springdatajpa.orm.Funcionario;

//public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {

	public List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND dataContratacao = :dataContratacao")
	public List<Funcionario> findByNomeSalarioMaiorDataContracao(String nome, Double salario, LocalDate dataContratacao);
	
	@Query(value = "SELECT f.* FROM TB_FUNCIONARIOS f WHERE f.dataContratacao >= :dataContratacao", nativeQuery = true)
	public List<Funcionario> buscarPorDataContracao(LocalDate dataContratacao);
	
}
