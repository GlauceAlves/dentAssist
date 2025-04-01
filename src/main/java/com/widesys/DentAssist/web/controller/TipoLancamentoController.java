package com.widesys.DentAssist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.widesys.DentAssist.application.service.TipoLancamentoService;
import com.widesys.DentAssist.domain.model.TipoLancamento;

@Controller
@RequestMapping("/tipolancamento")
public class TipoLancamentoController {
	private final TipoLancamentoService tipoLancamentoService;
	
	public TipoLancamentoController(TipoLancamentoService tipoLancamentoService) {
		this.tipoLancamentoService = tipoLancamentoService;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<TipoLancamento>> listaTipoLancamento(){
		return tipoLancamentoService.listaTipoLancamento();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TipoLancamento> buscaTipoLancamento(@PathVariable Long id){
		TipoLancamento tipoLancamentoEncontrado = tipoLancamentoService.buscaLancamentoId(id);
		return new ResponseEntity<>(tipoLancamentoEncontrado, HttpStatus.OK);
	}
	
	
	
}
