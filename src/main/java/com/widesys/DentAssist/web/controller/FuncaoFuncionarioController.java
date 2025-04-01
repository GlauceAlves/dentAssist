package com.widesys.DentAssist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widesys.DentAssist.application.service.FuncaoFuncionarioService;
import com.widesys.DentAssist.domain.model.FuncaoFuncionario;
import com.widesys.DentAssist.domain.model.Funcionario;

@RestController
@RequestMapping("/funcaofuncionario")
public class FuncaoFuncionarioController {
	private final  FuncaoFuncionarioService funcaoFuncionarioService;
	
	@Autowired
	public FuncaoFuncionarioController(FuncaoFuncionarioService funcaoFuncionarioService) {
		this.funcaoFuncionarioService = funcaoFuncionarioService;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<FuncaoFuncionario>> listarFuncaoFuncionario(){
		return funcaoFuncionarioService.listarFuncoesFuncionario();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<FuncaoFuncionario> buscarFuncionario(@PathVariable Long id){
		FuncaoFuncionario funcaoEncontrada = funcaoFuncionarioService.buscarFuncaoFuncionarioId(id);
		return ResponseEntity.ok(funcaoEncontrada);
	}
	
	
	
}


