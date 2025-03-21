package com.widesys.DentAssist.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.Funcionario;
import com.widesys.DentAssist.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public ResponseEntity<Iterable<Funcionario>> listarFuncionarios() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		if (!funcionarios.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(funcionarios, HttpStatus.OK);
	}

    public Funcionario buscarFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

//    public Funcionario buscarFuncionarioPorCpf(String cpf) {
//        Optional<Funcionario> funcionario = funcionarioRepository.findByCpf(cpf);
//        return funcionario.orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
//    }
//	
}
