package com.silvio.gestaoDeFrotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.gestaoDeFrotas.model.Condutor;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long>{
	List<Condutor> findAllByNome(String nome);
	Condutor findByCpf(String cpf);
	Condutor findByMatricula(Integer matricula);
	
}
