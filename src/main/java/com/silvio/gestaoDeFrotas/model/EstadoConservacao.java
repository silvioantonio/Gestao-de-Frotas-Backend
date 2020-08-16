package com.silvio.gestaoDeFrotas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EstadoConservacao {
	@JsonProperty("NOVO")NOVO, @JsonProperty("SEMI_NOVO")SEMI_NOVO, @JsonProperty("VELHO")VELHO
}
