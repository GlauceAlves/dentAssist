package com.widesys.DentAssist.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widesys.DentAssist.domain.model.FuncaoFuncionario;
import com.widesys.DentAssist.domain.repository.FuncaoFuncionarioRepository;

@Repository
public interface JpaFuncaoFuncionarioRepository extends JpaRepository<FuncaoFuncionario, Long> , FuncaoFuncionarioRepository{

}
