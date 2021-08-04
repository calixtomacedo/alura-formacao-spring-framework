package br.com.cmdev.springbootapirestiii.response;

public class LoginResponse {

	private String type;
	private String token;

	public LoginResponse(String token, String type) {
		this.token = token;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getToken() {
		return token;
	}
	
}
