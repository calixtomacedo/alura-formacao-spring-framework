package br.com.cmdev.javaejpa.model.vo;

import java.time.LocalDateTime;

/**
 * @author calixto.macedo - Calixto Macedo
 *
 */
public class RelatorioDeVendasVO {

	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDateTime dataUltimaVenda;

	public RelatorioDeVendasVO(String nomeProduto, Long quantidadeVendida, LocalDateTime dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDateTime getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVO [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida + ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
}
