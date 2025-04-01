package com.widesys.DentAssist.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widesys.DentAssist.domain.model.Usuario;
import com.widesys.DentAssist.domain.repository.UsuarioRepository;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepository {

}
