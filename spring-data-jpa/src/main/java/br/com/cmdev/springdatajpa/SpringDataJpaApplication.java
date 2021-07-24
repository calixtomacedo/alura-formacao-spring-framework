package br.com.cmdev.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cmdev.springdatajpa.orm.Cargo;
import br.com.cmdev.springdatajpa.repository.CargoRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private CargoRepository repository;
	
	public SpringDataJpaApplication(CargoRepository repository) {
		this.repository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Analista Desenvolvedor");
		repository.save(cargo);
	}

}
