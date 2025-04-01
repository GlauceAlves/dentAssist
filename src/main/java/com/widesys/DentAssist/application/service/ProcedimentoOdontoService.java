package com.widesys.DentAssist.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.ProcedimentoOdonto;
import com.widesys.DentAssist.domain.repository.ProcedimentoOdontoRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

import jakarta.transaction.Transactional;

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
	
	public ProcedimentoOdonto pesquisaProcedimento(Long id){
		return procedimentoOdontoRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Procedimento não encontrado com ID: " + id));
	}

 
	@Transactional	
	public ResponseEntity<String> registraProcedimento(ProcedimentoOdonto procedimentoOdonto){
		procedimentoOdontoRepository.save(procedimentoOdonto);
		return new ResponseEntity<>("Procedimento " + procedimentoOdonto.getDescricao() + " registrado com sucesso", HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<String> atualizaProcedimentoId(Long id , ProcedimentoOdonto procedimentoOdonto){
		Optional<ProcedimentoOdonto> existenteProcedimento = procedimentoOdontoRepository.findById(id);
		if (!existenteProcedimento.isPresent()) {
			return new ResponseEntity<>("Procedimento não foi encontrado atualização.", HttpStatus.NOT_FOUND);
		}
		ProcedimentoOdonto procedimentoAtualizado = existenteProcedimento.get();
		procedimentoAtualizado.setDescricao(procedimentoOdonto.getDescricao());
		procedimentoOdontoRepository.save(procedimentoOdonto);
		return new ResponseEntity<>("Procedimento " + procedimentoOdonto.getDescricao()+ " atualizado com sucesso." ,HttpStatus.OK);
	}

	public ResponseEntity<String> deletaProcedimento(Long id){
		Optional<ProcedimentoOdonto> existenteProcedimento = procedimentoOdontoRepository.findById(id);
		if (!existenteProcedimento.isPresent()) {
			return new ResponseEntity<String>("Procedimento " + id + " não encontrado.", HttpStatus.NOT_FOUND);
		}
		procedimentoOdontoRepository.deleteById(id);
		return new ResponseEntity<String>("Procedimento " + id + " - " + existenteProcedimento.get().getDescricao() + " deletado com sucesso.", HttpStatus.OK);
	}
}

