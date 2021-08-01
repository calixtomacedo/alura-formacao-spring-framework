package br.com.cmdev.sbootapirest.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cmdev.sbootapirest.model.Topico;

public class TopicoResponse {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoResponse(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<TopicoResponse> convertToTopico(List<Topico> topicoList) {
		return topicoList.stream().map(TopicoResponse::new).collect(Collectors.toList());
	}
	
}
