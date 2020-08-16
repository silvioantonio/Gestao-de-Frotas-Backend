package com.silvio.gestaoDeFrotas.model;

import javax.persistence.Id;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "condutor")
public class Condutor implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nome;
	
	@NotNull
	private String cpf;
	
	@NotNull
	@Min(value = 1)
	private Integer matricula;
	
	@Embedded
	private Cnh cnh;
	
	@OneToMany(mappedBy = "condutor", fetch = FetchType.LAZY)
	private List<OrdemDeTrafico> ordensDeTrafico;
	
	@Embedded
	private Endereco endereco;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Cnh getCnh() {
		return cnh;
	}

	public void setCnh(Cnh cnh) {
		this.cnh = cnh;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<OrdemDeTrafico> getOrdensDeTrafico() {
		return ordensDeTrafico;
	}

	public void setOrdensDeTrafico(List<OrdemDeTrafico> ordensDeTrafico) {
		this.ordensDeTrafico = ordensDeTrafico;
	}

}
