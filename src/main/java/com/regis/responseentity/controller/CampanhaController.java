package com.regis.responseentity.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regis.responseentity.model.Campanha;
import com.regis.responseentity.service.CampanhaService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "campanhas")
public class CampanhaController {

	@Autowired
	private CampanhaService campanhaService;
	
	@PostMapping(value = "")
	public ResponseEntity<Campanha> salvarCampanha(@RequestBody Campanha campanha) {
		Campanha campanhaSalva = campanhaService.salvarCampanha(campanha);
		return ResponseEntity.status(HttpStatus.CREATED).body(campanhaSalva);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Campanha>> listarCampanhaPorId(@PathVariable long id) throws NotFoundException {
		Optional<Campanha> campanha = campanhaService.listarCampanhaPorId(id);
		
		if (campanha.isPresent()) {
			return ResponseEntity.ok().body(campanha);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping(value = "")
	public ResponseEntity<Campanha> atualizarCampanha(@RequestBody Campanha campanha) {
		Campanha campanhaAtualizada = campanhaService.atualizarCampanha(campanha);
		return ResponseEntity.status(HttpStatus.CREATED).body(campanhaAtualizada);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> excluirCampanha(@PathVariable long id) {
		try {
			campanhaService.excluirCampanha(id);
			return ResponseEntity.status(HttpStatus.OK).body("Campanha " + id + " excluída com sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Campanha " + id + " não existe");
		}
	}
	
}