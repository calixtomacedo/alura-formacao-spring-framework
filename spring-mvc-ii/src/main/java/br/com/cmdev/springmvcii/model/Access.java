package br.com.cmdev.springmvcii.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ACESSOS")
public class Access {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SSS");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcesso;
	private String path;
	@JsonIgnore
	private LocalDateTime dateTime;
	private Duration duration;
	private String login;
	private String nome;
	
	public Long getIdAcesso() {
		return idAcesso;
	}
	public void setIdAcesso(Long idAcesso) {
		this.idAcesso = idAcesso;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDate() {
		return FORMATTER.format(dateTime);
	}
	
}
