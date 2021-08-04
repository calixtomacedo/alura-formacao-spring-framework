package br.com.cmdev.springbootapirestiii.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.com.cmdev.springbootapirestiii.model.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CursoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	private Curso curso;
	
	@BeforeEach
	public void setUp() {
		curso = new Curso();
		curso.setNome("Java 16");
		curso.setCategoria("Programação");
	}

	@Test
	public void deveriaCarregaUmCursoAoBuscarPeloNome() {
		entityManager.persist(curso);
		String nomeCurso = "Java 16";
		Curso curso = cursoRepository.findByNomeIgnoreCase(nomeCurso);
		assertNotNull(curso);
		assertEquals(nomeCurso, curso.getNome());
	}

}
