package com.widesys.DentAssist.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widesys.DentAssist.domain.model.TipoLancamento;
import com.widesys.DentAssist.domain.repository.TipoLancamentoRepository;

@Repository
public interface JpaTipoLancamentoRepository extends JpaRepository<TipoLancamento, Long>, TipoLancamentoRepository{

}
