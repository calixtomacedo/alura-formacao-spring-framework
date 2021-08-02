package br.com.cmdev.sbootapirestii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.sbootapirestii.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	public List<Topico> findByCursoNomeIgnoreCase(String nomeCurso);

}
