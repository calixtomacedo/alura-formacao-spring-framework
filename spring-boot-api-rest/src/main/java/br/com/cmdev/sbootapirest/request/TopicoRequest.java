package br.com.cmdev.sbootapirest.request;

import br.com.cmdev.sbootapirest.model.Curso;
import br.com.cmdev.sbootapirest.model.Topico;
import br.com.cmdev.sbootapirest.repository.CursoRepository;

public class TopicoRequest {

	private String titulo;
	private String mensagem;
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
