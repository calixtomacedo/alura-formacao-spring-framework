package br.com.cmdev.sbootapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmdev.sbootapirest.model.Topico;
import br.com.cmdev.sbootapirest.repository.TopicoRepository;
import br.com.cmdev.sbootapirest.response.TopicoResponse;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoResponse> getListTopico(String nomeCurso) {
		List<Topico> topicoList = null;
		if(nomeCurso == null || nomeCurso.isBlank()) {
			topicoList = topicoRepository.findAll();
		}else {
			topicoList = topicoRepository.findByCursoNomeIgnoreCase(nomeCurso);
		}
		
		return TopicoResponse.toMap(topicoList);
	}
}
