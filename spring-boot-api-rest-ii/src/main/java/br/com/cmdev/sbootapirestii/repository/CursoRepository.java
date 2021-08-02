package br.com.cmdev.sbootapirestii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.sbootapirestii.model.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Long> {

	public Curso findByNomeIgnoreCase(String nomeCurso);

}
