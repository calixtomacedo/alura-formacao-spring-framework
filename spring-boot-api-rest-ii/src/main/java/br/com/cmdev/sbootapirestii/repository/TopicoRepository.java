package br.com.cmdev.sbootapirestii.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.sbootapirestii.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	public Page<Topico> findByCursoNomeIgnoreCase(String nomeCurso, Pageable page);

}
