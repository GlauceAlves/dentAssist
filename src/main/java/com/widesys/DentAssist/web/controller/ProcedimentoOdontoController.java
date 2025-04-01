package com.widesys.DentAssist.web.controller;

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
	return procedimentoService.listarProcedimentos();
}

@GetMapping("/{id}")
	public ResponseEntity<ProcedimentoOdonto> PesquisaProcedimento(@PathVariable Long id){
    ProcedimentoOdonto procedimento = procedimentoService.pesquisaProcedimento(id);
    return new ResponseEntity<>(procedimento, HttpStatus.OK);
}


@PostMapping
	public ResponseEntity<String> registraProcedimento(@RequestBody ProcedimentoOdonto procedimentoOdonto){
	return procedimentoService.registraProcedimento(procedimentoOdonto);
}


@PutMapping("/{id}")
public ResponseEntity<String> atualizaProcedimentoId(@PathVariable Long id, @RequestBody ProcedimentoOdonto procedimentoOdonto){
return procedimentoService.atualizaProcedimentoId(id, procedimentoOdonto);
}


@DeleteMapping("{id}")
public ResponseEntity<String> deletaeProcedimento(@PathVariable Long id){
	return procedimentoService.deletaProcedimento(id);
}

}

