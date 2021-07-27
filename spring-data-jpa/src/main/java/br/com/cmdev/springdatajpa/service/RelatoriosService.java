package br.com.cmdev.springdatajpa.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.cmdev.springdatajpa.orm.Funcionario;
import br.com.cmdev.springdatajpa.orm.FuncionarioProjecao;
import br.com.cmdev.springdatajpa.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private final FuncionarioRepository funcionarioRepository;
	private Boolean StatusSystem = true;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (StatusSystem) {
			System.out.println("Qual acao de Funcionario deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Buscar Funcionarios por nome");
			System.out.println("2 - Buscar Funcionarios por nome, data e salario");
			System.out.println("3 - Buscar Funcionarios por data contratação");
			System.out.println("4 - Buscar Funcionarios Salario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscarPorNome(scanner);
				break;
			case 2:
				buscarPorNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscarPorDataContratacao(scanner);
				break;
			case 4:
				buscarFuncionarioSalario();
				break;
			default:
				StatusSystem = false;
				break;
			}
		}
	}

	private void buscarPorNome(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		List<Funcionario> funcionarioList = funcionarioRepository.findByNome(nome);

		funcionarioList.forEach(System.out::println);
	}
	
	private void buscarPorNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		System.out.println("Digite o saláro");
		Double salario = scanner.nextDouble();
		
		System.out.println("Digite a data de contratação");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionarioList = funcionarioRepository.findByNomeSalarioMaiorDataContracao(nome, salario, localDate);
		
		funcionarioList.forEach(System.out::println);
	}
	
	private void buscarPorDataContratacao(Scanner scanner) {
		System.out.println("Digite a data de contratação");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionarioList = funcionarioRepository.buscarPorDataContracao(localDate);
		
		funcionarioList.forEach(System.out::println);
	}
	
	private void buscarFuncionarioSalario() {
		
		List<FuncionarioProjecao> funcionarioSalario = funcionarioRepository.findFuncionarioSalario();
		
		funcionarioSalario.forEach(funcSal -> {
			System.out.println("ID: "+funcSal.getId()+", Nome: "+funcSal.getNome()+", Salario: "+funcSal.getSalario());
		});
	}
}
