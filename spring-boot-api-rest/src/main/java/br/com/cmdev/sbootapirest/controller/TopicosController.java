package br.com.cmdev.sbootapirest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cmdev.sbootapirest.model.Topico;
import br.com.cmdev.sbootapirest.repository.CursoRepository;
import br.com.cmdev.sbootapirest.repository.TopicoRepository;
import br.com.cmdev.sbootapirest.request.TopicoRequest;
import br.com.cmdev.sbootapirest.response.TopicoResponse;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoResponse> listar(String nomeCurso) {
		List<Topico> topicoList = null;
		if(nomeCurso == null || nomeCurso.isBlank()) {
			topicoList = topicoRepository.findAll();
		}else {
			topicoList = topicoRepository.findByCursoNomeIgnoreCase(nomeCurso);
		}

		return TopicoResponse.convertToTopico(topicoList);
	}
	
	@PostMapping
	public ResponseEntity<TopicoResponse> cadastrar(@RequestBody @Valid TopicoRequest topicoRequest, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoRequest.convertToTopico(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoResponse(topico));
	}
	
}
