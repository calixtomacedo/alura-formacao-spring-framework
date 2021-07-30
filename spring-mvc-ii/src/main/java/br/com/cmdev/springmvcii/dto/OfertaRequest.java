package br.com.cmdev.springmvcii.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.cmdev.springmvcii.model.Oferta;

public class OfertaRequest {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
	private Long idPedido;
	private String valorNegociado;
	private String dataDataEntrega;
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

	public String getDataDataEntrega() {
		return dataDataEntrega;
	}

	public void setDataDataEntrega(String dataDataEntrega) {
		this.dataDataEntrega = dataDataEntrega;
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
		oferta.setDataDataEntrega(LocalDate.parse(this.dataDataEntrega, FORMATTER) );
		oferta.setValorNegociado(new BigDecimal(this.valorNegociado));
		return oferta;
	}

}
