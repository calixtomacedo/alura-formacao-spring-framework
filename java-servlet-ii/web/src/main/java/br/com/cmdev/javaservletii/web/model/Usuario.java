package br.com.cmdev.javaservletii.web.model;

public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private Boolean logado;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setLogado(Boolean logado) {
		this.logado = logado;
	}

	public Boolean isUsuarioValido(String login, String senha) {
		if (!this.login.equals(login)) {
			this.setLogado(false);
			return false;
		}
		if (!this.senha.equals(senha)) {
			this.setLogado(false);
			return false;
		}
		this.setLogado(true);
		return true;
	}

	public boolean isLogged() {
		return this.logado;
	}

}
