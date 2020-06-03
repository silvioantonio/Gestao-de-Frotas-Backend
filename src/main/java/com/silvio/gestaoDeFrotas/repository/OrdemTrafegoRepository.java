package com.silvio.gestaoDeFrotas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.gestaoDeFrotas.model.OrdemDeTrafico;

@Repository
public interface OrdemTrafegoRepository extends JpaRepository<OrdemDeTrafico, Long> {
	List<OrdemDeTrafico> findAllByDataDaViagem(Date dataDaViagem);
	List<OrdemDeTrafico> findAllByOrigem(String origem);
	List<OrdemDeTrafico> findAllByDestino(String destino);
}
