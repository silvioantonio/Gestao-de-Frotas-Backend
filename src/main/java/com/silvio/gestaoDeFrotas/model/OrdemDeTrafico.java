package com.silvio.gestaoDeFrotas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.silvio.gestaoDeFrotas.util.DateHandler;

@Entity
@Table(name = "ordem_de_trafico")
public class OrdemDeTrafico implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String origem;
	
	@NotNull
	private String destino;
	
	//Para resolver o problema da recursividade, 
	// 1 retirar os getters de veiculo e condutor de dentro da ordem de trafego
	// 2 anotar veiculo e condutor dentro de ordem de trafego com @JsonIgnore
	// 3 manipular o setter dentro dos controllers
	@JsonBackReference(value = "veiculo-json")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;
	
	@JsonBackReference(value = "condutor-json")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "condutor_id")
	private Condutor condutor;
	
	@NotNull
	@Column(name = "data_da_viagem")
	@JsonDeserialize(using = DateHandler.class)
	private Date dataDaViagem;
	
	@NotNull
	@Column(name = "hora_da_viagem")
	private String horaDaViagem;
	
	@NotNull
	private String status;
	
	@NotNull
	@Column(name = "distancia_percorrida")
	private float distanciaPercorrida;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataDaViagem() {
		return dataDaViagem;
	}

	public void setDataDaViagem(Date dataDaViagem) {
		this.dataDaViagem = dataDaViagem;
	}

	public String getHoraDaViagem() {
		return horaDaViagem;
	}

	public void setHoraDaViagem(String horaDaViagem) {
		this.horaDaViagem = horaDaViagem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(float distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public Veiculo getVeiculo() {return veiculo;}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Condutor getCondutor() {return condutor;}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

}
