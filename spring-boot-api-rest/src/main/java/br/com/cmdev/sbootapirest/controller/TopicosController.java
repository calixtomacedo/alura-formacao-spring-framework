package br.com.cmdev.sbootapirest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cmdev.sbootapirest.model.Topico;
import br.com.cmdev.sbootapirest.repository.CursoRepository;
import br.com.cmdev.sbootapirest.repository.TopicoRepository;
import br.com.cmdev.sbootapirest.request.AtualizacaoTopicoRequest;
import br.com.cmdev.sbootapirest.request.TopicoRequest;
import br.com.cmdev.sbootapirest.response.DetalheTopicoResponse;
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
		if (nomeCurso == null || nomeCurso.isBlank()) {
			topicoList = topicoRepository.findAll();
		} else {
			topicoList = topicoRepository.findByCursoNomeIgnoreCase(nomeCurso);
		}

		return TopicoResponse.convertToTopico(topicoList);
	}
	
	@Transactional
	@PostMapping
	public ResponseEntity<TopicoResponse> cadastrar(@RequestBody @Valid TopicoRequest topicoRequest, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoRequest.convertToTopico(cursoRepository);
		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoResponse(topico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheTopicoResponse> datalhar(@PathVariable Long id) {
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			return ResponseEntity.ok(new DetalheTopicoResponse(topico.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<TopicoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoRequest atualizacaoTopicoRequest){
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if(optionalTopico.isPresent()) {
			Topico topico = atualizacaoTopicoRequest.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoResponse(topico));
		}
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<TopicoResponse> remover(@PathVariable Long id){
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if(optionalTopico.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	

}
