package com.widesys.DentAssist.domain.repository;

import java.util.Optional;

import com.widesys.DentAssist.domain.model.EspecialidadeOdonto;

public interface EspecialidadeOdontoRepository {
	Iterable<EspecialidadeOdonto> findAll();
	Optional<EspecialidadeOdonto> findById(Long idEspecialidade);
	
	EspecialidadeOdonto  save(EspecialidadeOdonto especialidadeOdonto);
	
	void deleteById(Long idEspecialidade);
	
}
