package com.widesys.DentAssist.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.ProcedimentoOdonto;
import com.widesys.DentAssist.domain.repository.ProcedimentoOdontoRepository;

@Service
public class ProcedimentoOdontoService {
	private final ProcedimentoOdontoRepository procedimentoOdontoRepository;
	
	@Autowired
	public ProcedimentoOdontoService(ProcedimentoOdontoRepository procedimentoOdontoRepository) {
		this.procedimentoOdontoRepository = procedimentoOdontoRepository;
	}
	
	public ResponseEntity<Iterable<ProcedimentoOdonto>> listarProcedimentos(){
		Iterable<ProcedimentoOdonto> listarProcedimentos = procedimentoOdontoRepository.findAll();
		if(!listarProcedimentos.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listarProcedimentos, HttpStatus.OK);
	}
}
