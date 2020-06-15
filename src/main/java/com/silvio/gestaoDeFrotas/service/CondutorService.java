package com.silvio.gestaoDeFrotas.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.silvio.gestaoDeFrotas.model.Condutor;
import com.silvio.gestaoDeFrotas.repository.CondutorRepository;

@Service
public class CondutorService extends AbstractRestService<Condutor, Long> {

	@Autowired
	private CondutorRepository condutorRepository;
	
	public List<Condutor> buscarPorNome(String nome) {
		return this.condutorRepository.findAllByNome(nome);
	}
	
	public Condutor buscarPorCpf(String cpf) {
		Condutor condutor = this.condutorRepository.findByCpf(cpf);
		return condutor;
	}
	
	public Condutor buscarPorMatricula(Integer matricula) {
		List<Condutor> condutores = this.condutorRepository.findByMatricula(matricula);
		return condutores.get(0);
	}
	
	public Condutor buscarPorCnh(Integer cnh) {
		Condutor condutor = this.condutorRepository.findAll().stream()
				.filter(e -> e.getCnh().getNumeroCNH() == cnh)
				.findAny()
				.orElseThrow(() -> new NoSuchElementException());
		return condutor;
	}

	@Override
	public JpaRepository<Condutor, Long> getRepository() {
		return this.condutorRepository;
	}
	
	
	
}
