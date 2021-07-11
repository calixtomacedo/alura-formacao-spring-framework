package cmdev.alura.java.jdbc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Categoria implements Serializable {

	private static final long serialVersionUID = -8395924346027698782L;
	
	private Integer idCategoria;
	private String nmCategoria;
	private Date dtCriacao;
	private Date dtAlteracao;
	private String flAtivo;
	private List<Produto> produtos;
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNmCategoria() {
		return nmCategoria;
	}
	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	public Date getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public Date getDtAlteracao() {
		return dtAlteracao;
	}
	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	public String getFlAtivo() {
		return flAtivo;
	}
	public void setFlAtivo(String flAtivo) {
		this.flAtivo = flAtivo;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return String.format("Categoria: idCategoria: %d, nome: %S, dtCriacao: %s, dtAlteracao: %s, Ativo: %S", this.idCategoria, this.nmCategoria, this.dtCriacao != null ? sdf.format(this.dtCriacao) : sdf.format(new Date()), this.dtAlteracao, this.flAtivo.equalsIgnoreCase("S") ? "SIM" : "NÃO");
	}
	
}
