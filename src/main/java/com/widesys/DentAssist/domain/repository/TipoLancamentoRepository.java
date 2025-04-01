package com.widesys.DentAssist.domain.repository;

import java.util.Optional;

import com.widesys.DentAssist.domain.model.TipoLancamento;

public interface TipoLancamentoRepository {

	Iterable<TipoLancamento> findAll();
	
	Optional<TipoLancamento> findById(Long id);
	
	TipoLancamento save(TipoLancamento tipoLancamento);
	
	void deleteById(Long id);
}
