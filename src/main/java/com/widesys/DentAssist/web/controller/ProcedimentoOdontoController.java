package com.widesys.DentAssist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widesys.DentAssist.application.service.ProcedimentoOdontoService;
import com.widesys.DentAssist.domain.model.ProcedimentoOdonto;

@RestController
@RequestMapping("/procedimentosodonto")
public class ProcedimentoOdontoController {
	private final ProcedimentoOdontoService procedimentoService;
	
	@Autowired
	public ProcedimentoOdontoController(ProcedimentoOdontoService procedimentoService) {
		this.procedimentoService = procedimentoService;
	}
	
@GetMapping
	public ResponseEntity<Iterable<ProcedimentoOdonto>> listarProcedimentos(){
		ResponseEntity<Iterable<ProcedimentoOdonto>> procedimentosResponse = procedimentoService.listarProcedimentos();
		if (procedimentosResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		Iterable<ProcedimentoOdonto> procedimentos = procedimentosResponse.getBody();
		return new ResponseEntity<>(procedimentos, HttpStatus.OK);
	}
}

