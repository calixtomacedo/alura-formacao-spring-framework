package br.com.cmdev.springbootapirestiii.response;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.cmdev.springbootapirestiii.model.Topico;

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

	public static Page<TopicoResponse> convertToTopico(Page<Topico> topicoList) {
		//return topicoList.stream().map(TopicoResponse::new).collect(Collectors.toList());
		return topicoList.map(TopicoResponse::new);
	}
	
}
