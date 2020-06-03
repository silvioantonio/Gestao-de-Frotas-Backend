package com.silvio.gestaoDeFrotas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.silvio.gestaoDeFrotas.util.DateHandler;


@Embeddable
public class Cnh{
	
	@NotNull
	@Column(name = "numero_cnh")
	@Min(value = 4)
	private Integer numeroCNH;
	
	@NotNull
	@JsonDeserialize(using = DateHandler.class)
	private Date validade;
		
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria_cnh")
	private CategoriaCnh categoriaCnh;

	public Integer getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(Integer numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public CategoriaCnh getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(CategoriaCnh categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}
	
	
}
