package com.silvio.gestaoDeFrotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silvio.gestaoDeFrotas.model.EstadoConservacao;
import com.silvio.gestaoDeFrotas.model.Marca;
import com.silvio.gestaoDeFrotas.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	Veiculo findByPlaca(String placa);
	List<Veiculo> findAllByKm(Integer km);
	List<Veiculo> findAllByModelo(String modelo);
	List<Veiculo> findAllByMarca(Marca marca);
	List<Veiculo> findAllByEstadoConservacao(EstadoConservacao estadoConservacao);
}
