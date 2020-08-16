package com.silvio.gestaoDeFrotas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoCombustivel {
	@JsonProperty("DIESEL")DIESEL, @JsonProperty("GASOLINA")GASOLINA, @JsonProperty("ALCOOL")ALCOOL, @JsonProperty("FLEX")FLEX
}
