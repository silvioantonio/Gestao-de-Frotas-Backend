package com.silvio.gestaoDeFrotas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Categoria {
	@JsonProperty("PASSEIO")PASSEIO, @JsonProperty("SUV")SUV, @JsonProperty("CAMINHONET")CAMINHONET, @JsonProperty("ONIBUS")ONIBUS, @JsonProperty("CAMINHAO")CAMINHAO, @JsonProperty("VAN")VAN
}
