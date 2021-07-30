package br.com.cmdev.springmvcii.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_OFERTAS")
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOferta;
	private BigDecimal valorNegociado;
	private LocalDate dataDataEntrega;
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPedido")
	private Pedido pedido;

	public Long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}

	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public LocalDate getDataDataEntrega() {
		return dataDataEntrega;
	}

	public void setDataDataEntrega(LocalDate dataDataEntrega) {
		this.dataDataEntrega = dataDataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
