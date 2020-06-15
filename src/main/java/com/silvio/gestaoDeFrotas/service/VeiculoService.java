package com.silvio.gestaoDeFrotas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.silvio.gestaoDeFrotas.model.EstadoConservacao;
import com.silvio.gestaoDeFrotas.model.Marca;
import com.silvio.gestaoDeFrotas.model.Veiculo;
import com.silvio.gestaoDeFrotas.repository.VeiculoRepository;

@Service
public class VeiculoService extends AbstractRestService<Veiculo, Long> {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo buscaPorPlaca(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        if(veiculo == null) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,  "Km colocado não esta vinculado aos veiculos salvos!");
        }
        return veiculo;
    }
	
	public List<Veiculo> buscaPorKm(Integer km) {
		List<Veiculo> veiculos = null;
		veiculos = veiculoRepository.findAllByKm(km);
		
		if(veiculos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,  "Km colocado não esta vinculado aos veiculos salvos!");
		}
		return veiculos;
	}
	
	public List<Veiculo> buscaPorModelo(String modelo) {
		List<Veiculo> veiculos = null;
		try {
		veiculos = veiculoRepository.findAllByModelo(modelo.toLowerCase());
		} catch (IllegalArgumentException i) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo nao existe na base de dados " + i.getMessage());
		}
		if(veiculos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,  "Modelo escolhido não esta vinculado a veiculos salvos!");
		}
		return veiculos;
	}
	
	public List<Veiculo> buscaPorMarca(String marca) {
		List<Veiculo> veiculos = null;
		try {
		veiculos = veiculoRepository.findAllByMarca(Marca.valueOf(marca.toUpperCase()));
		} catch (IllegalArgumentException i) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo nao existe na base de dados " + i.getMessage());
		}
		if(veiculos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,  "Tipo escolhido não esta vinculado a veiculos salvas!");
		}
		return veiculos;
	}
	
	public List<Veiculo> buscaPorEstadoDeConservacao(String estadoConservacao) {
		List<Veiculo> veiculos = null;
		try {
		veiculos = veiculoRepository.findAllByEstadoConservacao(EstadoConservacao.valueOf(estadoConservacao.toUpperCase()));
		} catch (IllegalArgumentException i) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo nao existe na base de dados " + i.getMessage());
		}
		if(veiculos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,  "Tipo escolhido não esta vinculado a veiculos salvas!");
		}
		return veiculos;
	}
	
	@Override
	public JpaRepository<Veiculo, Long> getRepository() {
		return this.veiculoRepository;
	} 

}
