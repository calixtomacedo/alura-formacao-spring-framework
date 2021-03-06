package br.com.cmdev.springdatajpa.orm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TB_FUNCIONARIOS")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	private LocalDate dataContratacao;
	
	@ManyToOne
	@JoinColumn(name = "idCargo", nullable = false)
	private Cargo cargo;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_FUNCIONARIOUNIDADES", joinColumns = { @JoinColumn(name = "idFuncionario") }, inverseJoinColumns = { @JoinColumn(name = "idUnidadeTrabalho") })
	private List<UnidadeTrabalho> unidadesTrabalho;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<UnidadeTrabalho> getUnidadesTrabalho() {
		return unidadesTrabalho;
	}

	public void setUnidadesTrabalho(List<UnidadeTrabalho> unidadesTrabalho) {
		this.unidadesTrabalho = unidadesTrabalho;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", dataContratacao=" + dataContratacao + ", cargo=" + cargo + ", unidadesTrabalho=" + unidadesTrabalho + "]";
	}
	
}
