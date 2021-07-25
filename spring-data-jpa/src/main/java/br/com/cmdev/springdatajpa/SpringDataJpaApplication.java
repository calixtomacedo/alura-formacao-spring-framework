package br.com.cmdev.springdatajpa;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cmdev.springdatajpa.service.CrudCargoService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Boolean statusSystem = true;
	
	private final CrudCargoService cargoService;
	
	public SpringDataJpaApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual a ação desejada?");
		System.out.println("0 - Sair");
		System.out.println("1 - Criar novo Cargo");
		while (statusSystem) {
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			}else {
				statusSystem = false;
			}
		}
	}

}