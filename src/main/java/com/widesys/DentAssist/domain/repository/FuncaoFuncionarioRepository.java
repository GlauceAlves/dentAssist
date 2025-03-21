package com.widesys.DentAssist.domain.repository;

import java.util.Optional;

import com.widesys.DentAssist.domain.model.FuncaoFuncionario;

public interface FuncaoFuncionarioRepository {
	Optional<FuncaoFuncionario> findById(Long idFuncao);
	Optional<FuncaoFuncionario> findBydescricao(String descricao);
	
	Iterable<FuncaoFuncionario> findAll();
	
	FuncaoFuncionario save(FuncaoFuncionario funcaoFuncionario);
	
	void deleteById(Long idFuncao);

}
