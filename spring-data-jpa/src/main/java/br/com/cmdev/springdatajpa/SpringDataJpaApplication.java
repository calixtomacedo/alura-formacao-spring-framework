package br.com.cmdev.springdatajpa;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cmdev.springdatajpa.service.CrudCargoService;
import br.com.cmdev.springdatajpa.service.CrudFuncionarioService;
import br.com.cmdev.springdatajpa.service.CrudUnidadeTrabalhoService;
import br.com.cmdev.springdatajpa.service.RelatoriosService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Boolean statusSystem = true;

	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	
	private final RelatoriosService relatoriosService;

	public SpringDataJpaApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatoriosService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (statusSystem) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatórios");

			Integer function = scanner.nextInt();

			switch (function) {
			case 1:
				funcionarioService.inicial(scanner);
				break;
			case 2:
				cargoService.inicial(scanner);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatoriosService.inicial(scanner);
				break;
			default:
				System.out.println("Finalizando");
				statusSystem = false;
				break;
			}
		}
	}

}