package br.com.cmdev.springbootapirestiii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.springbootapirestiii.model.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Long> {

	public Curso findByNomeIgnoreCase(String nomeCurso);

}
