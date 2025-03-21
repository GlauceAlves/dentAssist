package com.widesys.DentAssist.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.EspecialidadeOdonto;
import com.widesys.DentAssist.domain.repository.EspecialidadeOdontoRepository;

@Service
public class EspecialidadeOdontoService {
	private final EspecialidadeOdontoRepository especialidadeOdontoRepository;
	
	@Autowired
	public EspecialidadeOdontoService(EspecialidadeOdontoRepository especialidadeOdontoRepository) {
		this.especialidadeOdontoRepository = especialidadeOdontoRepository;
	}
	
	public ResponseEntity<Iterable<EspecialidadeOdonto>> listaEspecialidadeOdonto(){
		Iterable<EspecialidadeOdonto> listarEspecialidadeOdonto = especialidadeOdontoRepository.findAll();
		return new ResponseEntity<>(listarEspecialidadeOdonto, HttpStatus.OK);
	}
	
    public Optional<EspecialidadeOdonto> encontraEspecialidadeOdonto(Long id) {
        return especialidadeOdontoRepository.findById(id);
    }
	
	public ResponseEntity<EspecialidadeOdonto> gravaEspecialidadeOdonto(EspecialidadeOdonto especialidadeOdonto) {
	    EspecialidadeOdonto gravaEspecialidadeOdonto = especialidadeOdontoRepository.save(especialidadeOdonto);
	    return new ResponseEntity<>(gravaEspecialidadeOdonto, HttpStatus.CREATED);  
	}

	public ResponseEntity<EspecialidadeOdonto> alteraEspecialidadeOdonto(Long id, EspecialidadeOdonto especialidadeOdonto){
	    Optional<EspecialidadeOdonto> alteraEspecialidadeOdonto = especialidadeOdontoRepository.findById(id);
	    if (!alteraEspecialidadeOdonto.isPresent()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    EspecialidadeOdonto especialidadeExistente = alteraEspecialidadeOdonto.get();
	    especialidadeExistente.setDescricao(especialidadeOdonto.getDescricao());
	    especialidadeOdontoRepository.save(especialidadeExistente);
	    
	    return new ResponseEntity<>(especialidadeExistente, HttpStatus.OK);
	}
 	
	
	  public void deletaEspecialidadeOdonto(Long id) {
	        especialidadeOdontoRepository.deleteById(id);
	    }

}
