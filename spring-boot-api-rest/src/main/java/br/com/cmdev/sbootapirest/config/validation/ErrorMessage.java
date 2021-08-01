package br.com.cmdev.sbootapirest.config.validation;

public class ErrorMessage {

	private String field;
	private String message;

	public ErrorMessage(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
}
