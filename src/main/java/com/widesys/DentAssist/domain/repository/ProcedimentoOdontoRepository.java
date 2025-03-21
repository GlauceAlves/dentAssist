package com.widesys.DentAssist.domain.repository;

import java.util.Optional;

import com.widesys.DentAssist.domain.model.ProcedimentoOdonto;

public interface ProcedimentoOdontoRepository {

	Iterable<ProcedimentoOdonto> findAll();
	Optional<ProcedimentoOdonto> findById(Long idProcedimento);
	
	ProcedimentoOdonto save(ProcedimentoOdonto procedimentoOdonto);
	
	void deleteById(Long idProcedimento);
 
}
