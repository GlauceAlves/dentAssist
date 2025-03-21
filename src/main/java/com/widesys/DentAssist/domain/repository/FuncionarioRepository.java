package com.widesys.DentAssist.domain.repository;

import java.util.Optional;

import com.widesys.DentAssist.domain.model.Funcionario;

public interface FuncionarioRepository {
	
	
	Optional<Funcionario> findById(Long idFuncionario);
	Optional<Funcionario> findByCpf(String cpf);  
	Optional<Funcionario> findByNome(String nome);
	 
	Iterable<Funcionario> findAll();
	
	Funcionario save(Funcionario funcionario);
	
	void deleteById(Long idFuncionario);
	
	 

}
