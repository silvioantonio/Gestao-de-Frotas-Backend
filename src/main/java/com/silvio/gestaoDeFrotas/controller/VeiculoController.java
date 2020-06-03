package com.silvio.gestaoDeFrotas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvio.gestaoDeFrotas.model.Veiculo;
import com.silvio.gestaoDeFrotas.service.AbstractRestService;
import com.silvio.gestaoDeFrotas.service.VeiculoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/veiculos")
@Api(value="API REST Veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController extends AbstractRestController<Long, Veiculo>{

	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/km/{km}")
	public List<Veiculo> buscarPorKm(@PathVariable Integer km) {
		return this.veiculoService.buscaPorKm(km);
	}
	
	@GetMapping("/modelo/{modelo}")
	public List<Veiculo> buscarPorModelo(@PathVariable String modelo) {
		return this.veiculoService.buscaPorModelo(modelo);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Veiculo> buscarPorMarca(@PathVariable String marca) {
		return this.veiculoService.buscaPorMarca(marca);
	}
	
	@GetMapping("/estadoconservacao/{estadoconservacao}")
	public List<Veiculo> buscarPorEstadoDeConservacao(@PathVariable String estadoconservacao) {
		return this.veiculoService.buscaPorEstadoDeConservacao(estadoconservacao);
	}
	
	@Override
	public AbstractRestService<Veiculo, Long> getService() {
		return this.veiculoService;
	}
	
}
