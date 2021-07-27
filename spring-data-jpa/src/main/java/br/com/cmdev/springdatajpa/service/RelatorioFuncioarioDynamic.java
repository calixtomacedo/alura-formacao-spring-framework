package br.com.cmdev.springdatajpa.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.cmdev.springdatajpa.orm.Funcionario;
import br.com.cmdev.springdatajpa.repository.FuncionarioRepository;
import br.com.cmdev.springdatajpa.specification.FuncionarioSpecification;

@Service
public class RelatorioFuncioarioDynamic {

	private final FuncionarioRepository funcionarioRepository;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioFuncioarioDynamic(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite o cpf");
		String cpf = scanner.next();
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite o salario");
		Double salario = scanner.nextDouble();
		if(salario == 0) {
			salario = null;
		}
		
		System.out.println("Digite o data contratacao");
		String dtContratacao = scanner.next();
		LocalDate dataContratacao;
		if(dtContratacao.equalsIgnoreCase("NULL")) {
			dataContratacao = null;
		}else {
			dataContratacao = LocalDate.parse(scanner.next(), formatter);
		}
		
		List<Funcionario> funcionarioList = funcionarioRepository.findAll(Specification.where(
				FuncionarioSpecification.nome(nome))
				.or(FuncionarioSpecification.cpf(cpf))
				.or(FuncionarioSpecification.salario(salario))
				.or(FuncionarioSpecification.dataContratacao(dataContratacao)));
		
		funcionarioList.forEach(System.out::println);
	}
}
