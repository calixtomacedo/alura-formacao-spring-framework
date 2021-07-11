package cmdev.alura.java.jdbc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author calixto.macedo
 *
 */
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 7793336604835702874L;

	private Integer idProduto;
	private Categoria categoria;
	private String nmProduto;
	private String dsProduto;
	private LocalDateTime dtCriacao;
	private LocalDateTime dtAlteracao;
	private String flAtivo;
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getNmProduto() {
		return nmProduto;
	}
	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public LocalDateTime getDtCriacao() {
	    return dtCriacao;
	}
	public void setDtCriacao(LocalDateTime dtCriacao) {
	    this.dtCriacao = dtCriacao;
	}
	public LocalDateTime getDtAlteracao() {
	    return dtAlteracao;
	}
	public void setDtAlteracao(LocalDateTime dtAlteracao) {
	    this.dtAlteracao = dtAlteracao;
	}
	public String getFlAtivo() {
		return flAtivo;
	}
	public void setFlAtivo(String flAtivo) {
		this.flAtivo = flAtivo;
	}
	
	@Override
	public String toString() {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "";
		//return String.format("Produto idProduto: %d, nome: %S, descrição: %S, dtCriacao %s, dtAlteracao %s, Ativo %S", this.idProduto, this.nmProduto, this.dsProduto, this.dtCriacao != null ? sdf.format(this.dtCriacao) : sdf.format(new Date()), this.dtAlteracao, this.flAtivo.equalsIgnoreCase("S") ? "SIM" : "NÃO");
	}
	
}

