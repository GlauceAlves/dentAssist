package com.widesys.DentAssist.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.ProcedimentoOdonto;
import com.widesys.DentAssist.domain.model.Usuario;
import com.widesys.DentAssist.domain.repository.UsuarioRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

import jakarta.transaction.Transactional;

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
	
	
	@Transactional
	public ResponseEntity<String> registraUsuario(Usuario usuario){
		usuarioRepository.save(usuario);
		return new ResponseEntity<>("Usuário " + usuario.getNome() + " com sucesso", HttpStatus.OK);
	}
	
	
	@Transactional
	public ResponseEntity<String> alteraUsuario(Long id, Usuario usuario) {
		Optional<Usuario> existenteUsuario = usuarioRepository.findById(id);
		if (!existenteUsuario.isPresent()) {
			return new ResponseEntity<>("Usuario " + id + " não foi encontrado para atualização.", HttpStatus.NOT_FOUND);
		}
		Usuario usuarioAtualizado = existenteUsuario.get();
		usuarioAtualizado.setNome(usuario.getNome());
		usuarioAtualizado.setEmail(usuario.getEmail());
		usuarioAtualizado.setSenha(usuario.getSenha());
		usuarioRepository.save(usuarioAtualizado);
		return new ResponseEntity<>("Procedimento " + usuarioAtualizado.getNome()+ " atualizado com sucesso." ,HttpStatus.OK);
	}
	
	
	@Transactional
	public ResponseEntity<String> deletaUsuario(Long id) {
		Optional<Usuario> responseUsuario = usuarioRepository.findById(id);
		if(!responseUsuario.isPresent()) {
			return new ResponseEntity<String>("Usuario " + id + " não encontrado", HttpStatus.NOT_FOUND);
		}
		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>("Usuario " + id + " deletado com sucesso", HttpStatus.OK);
	}
	
	
}
