package com.widesys.DentAssist.web.controller;

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

import com.widesys.DentAssist.application.service.EspecialidadeOdontoService;
import com.widesys.DentAssist.domain.model.EspecialidadeOdonto;

@RestController
@RequestMapping("/especialidadeodonto")
public class EspecialidadeOdontoController {
	private final EspecialidadeOdontoService especialidadeOdontoService;

	@Autowired
	public EspecialidadeOdontoController(EspecialidadeOdontoService especialidadeOdontoService) {
		this.especialidadeOdontoService = especialidadeOdontoService;
	}

	@GetMapping
	public ResponseEntity<Iterable<EspecialidadeOdonto>> listaEspecialidadeOdonto() {
		ResponseEntity<Iterable<EspecialidadeOdonto>> especialidadesResponse = especialidadeOdontoService
				.listaEspecialidadeOdonto();
		if (especialidadesResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		Iterable<EspecialidadeOdonto> especialidades = especialidadesResponse.getBody();
		return new ResponseEntity<>(especialidades, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialidadeOdonto> encontreEspecialidadeOdonto(@PathVariable Long id) {
	    Optional<EspecialidadeOdonto> especialidade = especialidadeOdontoService.encontraEspecialidadeOdonto(id);

	    if (especialidade.isPresent()) {
	        return new ResponseEntity<>(especialidade.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping
		public ResponseEntity<EspecialidadeOdonto> gravaEspecialidadeOdonto(@RequestBody EspecialidadeOdonto especialidadeOdonto){
		ResponseEntity<EspecialidadeOdonto> especialidadeResponse = especialidadeOdontoService.gravaEspecialidadeOdonto(especialidadeOdonto);

		EspecialidadeOdonto especialidade = especialidadeResponse.getBody();
		return new ResponseEntity<>(especialidade, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EspecialidadeOdonto> alteraEspecialidadeOdonto(@PathVariable Long id, @RequestBody EspecialidadeOdonto especialidadeOdonto) {
	    ResponseEntity<EspecialidadeOdonto> especialidadeResponse = especialidadeOdontoService.alteraEspecialidadeOdonto(id, especialidadeOdonto);
	    
	    if (especialidadeResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
	    }
	    
	    EspecialidadeOdonto especialidadeAlterada = especialidadeResponse.getBody();
	    return new ResponseEntity<>(especialidadeAlterada, HttpStatus.OK);   
	}
 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarEspecialidadeOdonto(@PathVariable Long id) {
	    Optional<EspecialidadeOdonto> especialidade = especialidadeOdontoService.encontraEspecialidadeOdonto(id);

	    if (especialidade.isPresent()) {
	        especialidadeOdontoService.deletaEspecialidadeOdonto(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
 
}
