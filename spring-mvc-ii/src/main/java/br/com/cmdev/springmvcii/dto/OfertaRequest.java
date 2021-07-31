package br.com.cmdev.springmvcii.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.cmdev.springmvcii.model.Oferta;

public class OfertaRequest {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long idPedido;
	
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	@NotBlank
	private String valorNegociado;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotBlank
	private String dataEntrega;
	private String comentario;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(String valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataDataEntrega(LocalDate.parse(this.dataEntrega, FORMATTER) );
		oferta.setValorNegociado(new BigDecimal(this.valorNegociado));
		return oferta;
	}

}
