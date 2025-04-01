package com.widesys.DentAssist.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.widesys.DentAssist.application.service.UsuarioService;
import com.widesys.DentAssist.domain.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Usuario>> listaUsuario(){
		return usuarioService.listaUsuario();
	}
	
	@GetMapping("{id}")
	public Usuario encontraUsuario(@PathVariable Long id){
		return usuarioService.encontraUsuarioId(id);
	}
	
	
}
