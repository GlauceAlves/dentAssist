package com.widesys.DentAssist.domain.repository;

import java.util.Optional;

import com.widesys.DentAssist.domain.model.Usuario;

public interface UsuarioRepository {

	Iterable<Usuario> findAll();
	Optional<Usuario> findById(Long id);
	
	Usuario save(Usuario usuario);
	
	void deleteById(Long id);
}
