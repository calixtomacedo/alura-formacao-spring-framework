package br.com.cmdev.springmvcii.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.model.enums.StatusPedido;

public class PedidoRequest {

	@Length(min = 5, max = 255)
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(this.nomeProduto);
		pedido.setUrlProduto(this.urlProduto);
		pedido.setUrlImagem(this.urlImagem);
		pedido.setDescricao(this.descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}

}
