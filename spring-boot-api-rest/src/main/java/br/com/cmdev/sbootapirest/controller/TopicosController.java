package br.com.cmdev.sbootapirest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmdev.sbootapirest.model.Curso;
import br.com.cmdev.sbootapirest.model.Topico;
import br.com.cmdev.sbootapirest.response.TopicoResponse;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoResponse> getListTopico(){
		Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
		return TopicoResponse.map(Arrays.asList(topico, topico, topico));
	}
}
