package com.widesys.DentAssist.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widesys.DentAssist.domain.model.EspecialidadeOdonto;
import com.widesys.DentAssist.domain.repository.EspecialidadeOdontoRepository;

@Repository
public interface JpaEspecialidadeOdontoRepository extends JpaRepository<EspecialidadeOdonto, Long> , EspecialidadeOdontoRepository{

}
