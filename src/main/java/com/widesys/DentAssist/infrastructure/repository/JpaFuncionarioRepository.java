package com.widesys.DentAssist.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widesys.DentAssist.domain.model.Funcionario;
import com.widesys.DentAssist.domain.repository.FuncionarioRepository;

@Repository
public interface JpaFuncionarioRepository extends JpaRepository<Funcionario, Long>, FuncionarioRepository{
	
	 Optional<Funcionario> findByCpf(String cpf);  	 
	 Optional<Funcionario> findByNome(String nome);
	 
}
