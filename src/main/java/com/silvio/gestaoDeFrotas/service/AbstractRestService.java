package com.silvio.gestaoDeFrotas.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractRestService<E, ID> {
	public abstract JpaRepository<E, ID> getRepository();
}
