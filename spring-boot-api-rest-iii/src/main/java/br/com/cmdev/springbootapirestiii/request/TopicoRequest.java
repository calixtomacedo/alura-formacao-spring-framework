package br.com.cmdev.springbootapirestiii.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.cmdev.springbootapirestiii.model.Curso;
import br.com.cmdev.springbootapirestiii.model.Topico;
import br.com.cmdev.springbootapirestiii.repository.CursoRepository;

public class TopicoRequest {

	@NotNull @NotEmpty @Length(min = 5, max = 255)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10, max = 255)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeCurso;

	
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

	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico convertToTopico(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNomeIgnoreCase(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
