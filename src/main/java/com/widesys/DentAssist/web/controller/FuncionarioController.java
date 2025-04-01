package com.widesys.DentAssist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widesys.DentAssist.application.service.FuncionarioService;
import com.widesys.DentAssist.domain.model.Funcionario;

@CrossOrigin(origins = "(http://localhost:8081")

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioservice;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioservice) {
		this.funcionarioservice = funcionarioservice;
	}

	@GetMapping
	public ResponseEntity<Iterable<Funcionario>> listarFuncionarios() {
			return funcionarioservice.listarFuncionarios();
		}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> pesquisaFuncionarioId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioservice.buscarFuncionarioPorId(id);
		return ResponseEntity.ok(funcionario);
	}

	@PostMapping
	public ResponseEntity<String> registraFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioservice.registraFuncionario(funcionario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> atualizaFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return funcionarioservice.atualizaFuncionario(id, funcionario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletaFuncionario(@PathVariable Long id) {
		return funcionarioservice.deletaFuncionario(id);
	}
	



}
