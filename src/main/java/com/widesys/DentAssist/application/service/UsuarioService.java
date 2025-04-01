package com.widesys.DentAssist.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.Usuario;
import com.widesys.DentAssist.domain.repository.UsuarioRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
//	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public ResponseEntity<Iterable<Usuario>> listaUsuario(){
		Iterable<Usuario> usuarioListado = usuarioRepository.findAll();
		if(!usuarioListado.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(usuarioListado, HttpStatus.OK);
	}
	
	public Usuario encontraUsuarioId(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Usuário não encontrado " + id));
	}
	
	
}
