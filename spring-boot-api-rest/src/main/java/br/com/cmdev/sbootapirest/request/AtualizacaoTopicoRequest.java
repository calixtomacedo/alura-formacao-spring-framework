package br.com.cmdev.sbootapirest.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.cmdev.sbootapirest.model.Topico;
import br.com.cmdev.sbootapirest.repository.TopicoRepository;

public class AtualizacaoTopicoRequest {

	@NotNull @NotEmpty @Length(min = 5, max = 255)
	private String titulo;

	@NotNull @NotEmpty @Length(min = 10, max = 255)
	private String mensagem;

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.findById(id).get();
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}

}
