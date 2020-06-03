package com.silvio.gestaoDeFrotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvio.gestaoDeFrotas.model.Condutor;
import com.silvio.gestaoDeFrotas.service.AbstractRestService;
import com.silvio.gestaoDeFrotas.service.CondutorService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/condutores")
@Api(value="API REST Condutores")
@CrossOrigin(origins = "*")
public class CondutorController extends AbstractRestController<Long,Condutor>{

	@Autowired
	private CondutorService condutorService;
	
	@GetMapping("/nome/{nome}")
	public List<Condutor> buscarPorNome(@PathVariable String nome) {
		return this.condutorService.buscarPorNome(nome);
	}
	
	@GetMapping("/cpf/{cpf}")
	public Condutor buscarPorCpf(@PathVariable String cpf) {
		return this.condutorService.buscarPorCpf(cpf);
	}
	
	@GetMapping("/matricula/{matricula}")
	public Condutor buscarPorMatricula(@PathVariable Integer matricula) {
		return this.condutorService.buscarPorMatricula(matricula);
	}
	
	@GetMapping("/cnh/{cnh}")
	public Condutor buscarPorCnh(@PathVariable Integer cnh) {
		return this.condutorService.buscarPorCnh(cnh);
	}
	
	@Override
	public AbstractRestService<Condutor, Long> getService() {
		return this.condutorService;
	}

}
