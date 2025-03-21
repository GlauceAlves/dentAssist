package com.widesys.DentAssist.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.FuncaoFuncionario;
import com.widesys.DentAssist.domain.repository.FuncaoFuncionarioRepository;

@Service
public class FuncaoFuncionarioService {
	private final FuncaoFuncionarioRepository funcaofuncionarioRepository;
	
	@Autowired
	public FuncaoFuncionarioService(FuncaoFuncionarioRepository funcaofuncionarioRepository) {
		this.funcaofuncionarioRepository = funcaofuncionarioRepository;
	}

	public ResponseEntity<Iterable<FuncaoFuncionario>> listarFuncoesFuncionario() {
		Iterable<FuncaoFuncionario> listarFuncoesFuncionario = funcaofuncionarioRepository.findAll();
		if(!listarFuncoesFuncionario.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listarFuncoesFuncionario, HttpStatus.OK);
	}

}
