package br.com.cmdev.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cmdev.springdatajpa.orm.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

}
