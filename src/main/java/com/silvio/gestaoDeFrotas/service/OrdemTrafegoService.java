package com.silvio.gestaoDeFrotas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.silvio.gestaoDeFrotas.model.Condutor;
import com.silvio.gestaoDeFrotas.model.OrdemDeTrafico;
import com.silvio.gestaoDeFrotas.model.Veiculo;
import com.silvio.gestaoDeFrotas.repository.CondutorRepository;
import com.silvio.gestaoDeFrotas.repository.OrdemTrafegoRepository;
import com.silvio.gestaoDeFrotas.repository.VeiculoRepository;

@Service
public class OrdemTrafegoService extends AbstractRestService<OrdemDeTrafico, Long> {

	@Autowired
	private OrdemTrafegoRepository ordemTrafegoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private CondutorRepository condutorRepository;
	
	//public List<OrdemDeTrafico> buscarTodos() {
	//	return this.ordemTrafegoRepository.findAll().
	//}
	
	public List<OrdemDeTrafico> buscarOrdemPorVeiculo(Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		try {
			return veiculo.get().getOrdensDeTrafico();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public List<OrdemDeTrafico> buscarOrdemPorCondutor(Long id) {
		Optional<Condutor> condutor = condutorRepository.findById(id);
		try {
			return condutor.get().getOrdensDeTrafico();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public List<OrdemDeTrafico> buscaOrdensPorData(String dataViagem) {
		List<OrdemDeTrafico> ordensTrafego = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			Date d = sdf.parse(dataViagem);
			ordensTrafego = ordemTrafegoRepository.findAllByDataDaViagem(d);
		} catch (IllegalArgumentException i) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "A Data não pode ser nulo!");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (ordensTrafego.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "Data não existe para ordens salvas!");
		}
		
		return ordensTrafego;
	}

	public List<OrdemDeTrafico> buscaOndensPorOrigem(String origem) {
		List<OrdemDeTrafico> ordensTrafego = null;
		try {
			ordensTrafego = ordemTrafegoRepository.findAllByOrigem(origem.toLowerCase());
		} catch (IllegalArgumentException i) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "A Origem não pode ser nula!");
		}
		if (ordensTrafego.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "Origem não existe para ordens salvas!");
		}
		return ordensTrafego;
	}
	
	public List<OrdemDeTrafico> buscaOndensPorDestino(String destino) {
		List<OrdemDeTrafico> ordensTrafego = null;
		try {
			ordensTrafego = ordemTrafegoRepository.findAllByDestino(destino.toLowerCase());
		} catch (IllegalArgumentException i) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "O Destino não pode ser nulo!");
		}
		if (ordensTrafego.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "Destino não existe para ordens salvas!");
		}
		return ordensTrafego;
	}
	
	@Override
	public JpaRepository<OrdemDeTrafico, Long> getRepository() {
		return this.ordemTrafegoRepository;
	}

}
