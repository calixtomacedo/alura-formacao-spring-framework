package br.com.cmdev.sbootapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.sbootapirest.model.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Long> {

	public Curso findByNomeIgnoreCase(String nomeCurso);

}
