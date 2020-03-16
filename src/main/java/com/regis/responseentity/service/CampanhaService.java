package com.regis.responseentity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regis.responseentity.model.Campanha;
import com.regis.responseentity.repository.CampanhaRepository;

@Service
public class CampanhaService {

	@Autowired
	private CampanhaRepository campanhaRepository;
	
	public Campanha salvarCampanha(Campanha campanha) {
		return campanhaRepository.save(campanha);
	}

	public Optional<Campanha> listarCampanhaPorId(long id) {
		return campanhaRepository.findById(id);
	}
	
	public Campanha atualizarCampanha(Campanha campanha) {
		return campanhaRepository.save(campanha);
	}

	public void excluirCampanha(long id) {
		campanhaRepository.deleteById(id);
	}
	
}