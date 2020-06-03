package com.silvio.gestaoDeFrotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvio.gestaoDeFrotas.model.OrdemDeTrafico;
import com.silvio.gestaoDeFrotas.service.AbstractRestService;
import com.silvio.gestaoDeFrotas.service.OrdemTrafegoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/ordemtrafego")
@Api(value="API REST Ordem de Trafego")
@CrossOrigin(origins = "*")
public class OrdemTrafegoController extends AbstractRestController<Long,OrdemDeTrafico> {

	@Autowired
	private OrdemTrafegoService ordemTrafegoService;
	
	@GetMapping("/veiculo/{id}")
	public List<OrdemDeTrafico> buscarTodosPorVeiculo(@PathVariable Long id){
		return this.ordemTrafegoService.buscarOrdemPorVeiculo(id);
	}
	
	@GetMapping("/condutor/{id}")
	public List<OrdemDeTrafico> buscarTodosPorCondutor(@PathVariable Long id){
		return this.ordemTrafegoService.buscarOrdemPorCondutor(id);
	}
	
	@GetMapping("/data/{data}")
	public List<OrdemDeTrafico> buscaPorData(@PathVariable String data){
		return this.ordemTrafegoService.buscaOrdensPorData(data);
	}
	
	@GetMapping("/origem/{origem}")
	public List<OrdemDeTrafico> buscaPorOrigem(@PathVariable String origem){
		return this.ordemTrafegoService.buscaOndensPorOrigem(origem);
	}
	
	@GetMapping("/destino/{destino}")
	public List<OrdemDeTrafico> buscaPorDestino(@PathVariable String destino){
		return this.ordemTrafegoService.buscaOndensPorDestino(destino);
	}
	
	@Override
	public AbstractRestService<OrdemDeTrafico, Long> getService() {
		return this.ordemTrafegoService;
	}

}
