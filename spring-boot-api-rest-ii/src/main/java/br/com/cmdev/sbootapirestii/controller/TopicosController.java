package br.com.cmdev.sbootapirestii.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cmdev.sbootapirestii.model.Topico;
import br.com.cmdev.sbootapirestii.repository.CursoRepository;
import br.com.cmdev.sbootapirestii.repository.TopicoRepository;
import br.com.cmdev.sbootapirestii.request.AtualizacaoTopicoRequest;
import br.com.cmdev.sbootapirestii.request.TopicoRequest;
import br.com.cmdev.sbootapirestii.response.DetalheTopicoResponse;
import br.com.cmdev.sbootapirestii.response.TopicoResponse;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	//public Page<TopicoResponse> listar(@RequestParam(required = false) String nomeCurso, @RequestParam int pagina, @RequestParam int quant, @RequestParam String ordem) {
	@GetMapping
	@Cacheable(value = "listaDeTopicos")
	public Page<TopicoResponse> listar(@RequestParam(required = false) String nomeCurso, @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		//Pageable pagination = PageRequest.of(pagina, quant, Direction.ASC, ordem);
		Page<Topico> topicoList = null;
		if (nomeCurso == null || nomeCurso.isBlank()) {
			topicoList = topicoRepository.findAll(paginacao);
		} else {
			topicoList = topicoRepository.findByCursoNomeIgnoreCase(nomeCurso, paginacao);
		}

		return TopicoResponse.convertToTopico(topicoList);
	}
	
	@Transactional
	@PostMapping
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
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
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
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
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoResponse> remover(@PathVariable Long id){
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if(optionalTopico.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	

}
