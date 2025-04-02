package com.widesys.DentAssist.application.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.TipoLancamento;
import com.widesys.DentAssist.domain.repository.TipoLancamentoRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TipoLancamentoService {
	private final TipoLancamentoRepository tipoLancamentoRepository;
	
	public TipoLancamentoService(TipoLancamentoRepository tipoLancamentoRepository) {
		this.tipoLancamentoRepository = tipoLancamentoRepository;
	}

	public ResponseEntity<Iterable<TipoLancamento>> listaTipoLancamento(){
		Iterable<TipoLancamento> tipoLancamentoListados = tipoLancamentoRepository.findAll();
		if(!tipoLancamentoListados.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tipoLancamentoListados,HttpStatus.OK);
	}
	
	public TipoLancamento buscaLancamentoId(Long id){
		return tipoLancamentoRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Tipo de lantamento não encontrato " + id));
	}
	
	@Transactional	
	public ResponseEntity<String> registraTipoLancamento(TipoLancamento tipoLancamento){
		tipoLancamentoRepository.save(tipoLancamento);
		return new ResponseEntity<>("Tipo lançamento " + tipoLancamento.getDescricao() + " registrado com sucesso", HttpStatus.OK);
	}
	
	
	@Transactional
	public ResponseEntity<TipoLancamento> alteraTipoLancamento(Long id, TipoLancamento tipoLancamento){
		Optional<TipoLancamento> responseTipoLancamento = tipoLancamentoRepository.findById(id);
		if (!responseTipoLancamento.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		TipoLancamento tipoLancamentoAlterado = responseTipoLancamento.get();
		tipoLancamentoAlterado.setDescricao(tipoLancamento.getDescricao()); 
		tipoLancamentoAlterado.setTipoLancamento(tipoLancamento.getTipoLancamento()); 
		tipoLancamentoRepository.save(tipoLancamentoAlterado);
		return new ResponseEntity<>(tipoLancamentoAlterado, HttpStatus.OK); 
	}
	
	@Transactional
	public ResponseEntity<String> deletaTipoLancamento(Long id) {
		Optional<TipoLancamento> responseTipoLancamento = tipoLancamentoRepository.findById(id);
		if (!responseTipoLancamento.isPresent()) {
			return new ResponseEntity<>("Tipo de lançamento " + id + "não encontrado.",HttpStatus.NOT_FOUND); 
		}
		tipoLancamentoRepository.deleteById(id);
		return new ResponseEntity<String>("Tipo de lançamento " + id + " deletado com sucesso",HttpStatus.OK);
	}
	
}
