package com.widesys.DentAssist.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.TipoLancamento;
import com.widesys.DentAssist.domain.repository.TipoLancamentoRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

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
}
