package com.silvio.gestaoDeFrotas.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

	@NotBlank
	@Size(min = 3, max = 20)
	private String cidade;
	
	@NotBlank
	@Size(min = 3, max = 20)
	private String bairro;
	
	@NotBlank
	@Size(min = 3, max = 20)
	private String complemento;
	
	private int numero;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
