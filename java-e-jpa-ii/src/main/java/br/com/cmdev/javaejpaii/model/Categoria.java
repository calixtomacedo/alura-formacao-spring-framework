package br.com.cmdev.javaejpaii.model;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria {

	//@Id
	//@Column(name = "IDCATEGORIA")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	
	@EmbeddedId
	private CategoriaId id;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();

	
	public Categoria() {}
	
	public Categoria(String descricao) {
		this.id = new CategoriaId(descricao, "xpto");
	}
	
	public String getDescricao() {
		return this.id.getDescricao();
	}


	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
