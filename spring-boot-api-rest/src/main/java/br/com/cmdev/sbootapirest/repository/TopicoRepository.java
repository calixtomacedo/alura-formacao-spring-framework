package br.com.cmdev.sbootapirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.sbootapirest.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	public List<Topico> findByCursoNomeIgnoreCase(String nomeCurso);

}
