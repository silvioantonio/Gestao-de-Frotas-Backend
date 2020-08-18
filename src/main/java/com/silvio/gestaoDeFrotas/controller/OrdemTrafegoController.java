package com.silvio.gestaoDeFrotas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvio.gestaoDeFrotas.model.Condutor;
import com.silvio.gestaoDeFrotas.model.OrdemDeTrafico;
import com.silvio.gestaoDeFrotas.model.Veiculo;
import com.silvio.gestaoDeFrotas.repository.CondutorRepository;
import com.silvio.gestaoDeFrotas.repository.VeiculoRepository;
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
	
	@Autowired
	private CondutorRepository condutorRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
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
	
	@PostMapping
	public ResponseEntity<OrdemDeTrafico> salvar (@Valid @RequestBody OrdemDeTrafico ordem, HttpServletResponse response)  {
		  List<Condutor> c = condutorRepository.findByMatricula(ordem.getCondutor().getMatricula());
		  ordem.setCondutor(c.get(0));
		  
		  List<Veiculo> v = veiculoRepository.findByPlaca(ordem.getVeiculo().getPlaca());
		  ordem.setVeiculo(v.get(0));

		  OrdemDeTrafico t2 = this.ordemTrafegoService.getRepository().save(ordem);
		  return ResponseEntity.status(HttpStatus.CREATED).body(t2);
		}
	
	@Override
	public AbstractRestService<OrdemDeTrafico, Long> getService() {
		return this.ordemTrafegoService;
	}

}
