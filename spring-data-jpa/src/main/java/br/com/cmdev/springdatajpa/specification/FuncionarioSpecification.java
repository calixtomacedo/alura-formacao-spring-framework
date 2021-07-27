package br.com.cmdev.springdatajpa.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.cmdev.springdatajpa.orm.Funcionario;

public class FuncionarioSpecification {

	public static Specification<Funcionario> nome(String nome) {
		return (root, creteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%".concat(nome).concat("%"));
	}
	
	public static Specification<Funcionario> cpf(String cpf) {
		return (root, creteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario> salario(Double salario) {
		return (root, creteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario> dataContratacao(LocalDate dtContratacao) {
		return (root, creteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dataContratacao"), dtContratacao);
	}
	
}
