package com.widesys.DentAssist.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widesys.DentAssist.domain.model.ProcedimentoOdonto;
import com.widesys.DentAssist.domain.repository.ProcedimentoOdontoRepository;

@Repository
public interface JpaProcedimentoOdontoRepository extends JpaRepository<ProcedimentoOdonto, Long> ,  ProcedimentoOdontoRepository{

}
