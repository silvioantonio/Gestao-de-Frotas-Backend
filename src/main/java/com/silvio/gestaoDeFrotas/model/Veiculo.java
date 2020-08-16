package com.silvio.gestaoDeFrotas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String modelo;
	
	@NotNull
	@Length(max = 7)
	private String placa;
	
	@NotNull
	@Length(min = 3, max = 8)
	private String cor;
	
	@NotNull
	@Min(value = 1)
	private Integer km;
	
	@NotNull
	@Column(name = "ano_fabricacao")
	private int anoFabricacao;
	
	@JsonManagedReference(value = "veiculo-json")
	@OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
	private List<OrdemDeTrafico> ordensDeTrafico;

	@Enumerated(EnumType.STRING)
	private Marca marca;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_combustivel")
	private TipoCombustivel tipoCombustivel;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_conservacao")
	private EstadoConservacao estadoConservacao;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public EstadoConservacao getEstadoConservacao() {
		return estadoConservacao;
	}

	public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
		this.estadoConservacao = estadoConservacao;
	}

	public List<OrdemDeTrafico> getOrdensDeTrafico() {
		return ordensDeTrafico;
	}

	public void setOrdensDeTrafico(List<OrdemDeTrafico> ordensDeTrafico) {
		this.ordensDeTrafico = ordensDeTrafico;
	}
	

}
