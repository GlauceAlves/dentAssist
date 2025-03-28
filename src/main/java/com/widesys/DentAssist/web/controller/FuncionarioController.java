package com.widesys.DentAssist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widesys.DentAssist.application.service.FuncionarioService;
import com.widesys.DentAssist.domain.model.Funcionario;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioservice;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioservice) {
		this.funcionarioservice = funcionarioservice;
	}
	
 
    @GetMapping
    public ResponseEntity<Iterable<Funcionario>> listarFuncionarios() {
    	ResponseEntity<Iterable<Funcionario>> funcionariosResponse = funcionarioservice.listarFuncionarios();
    	if (funcionariosResponse.getStatusCode() == HttpStatus.NO_CONTENT) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
        Iterable<Funcionario> funcionarios = funcionariosResponse.getBody();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    	}
    }	
	
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> pesquisaFuncionarioId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioservice.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    
    @PostMapping
    public ResponseEntity<String> registraFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioservice.registraFuncionario(funcionario);   
    }    



//	@PutMapping("/{id}")
//	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
//		Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
//
//		if (existingFuncionario.isPresent()) {
//			Funcionario updatedFuncionario = existingFuncionario.get();
//			updatedFuncionario.setNomeFuncionario(funcionario.getNomeFuncionario());
//			updatedFuncionario.setCpfFuncionario(funcionario.getCpfFuncionario());
//			updatedFuncionario.setTelefones(funcionario.getTelefones());
//			updatedFuncionario.setEnderecoFuncionario(funcionario.getEnderecoFuncionario());
//			updatedFuncionario.setFuncaoFuncionario(funcionario.getFuncaoFuncionario());
//			updatedFuncionario.setEspecialidadesOdonto(funcionario.getEspecialidadesOdonto());
//			funcionarioRepository.save(updatedFuncionario);
//			return new ResponseEntity<>(updatedFuncionario, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
// 
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
//		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
//
//		if (funcionario.isPresent()) {
//			funcionarioRepository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
//		}
//	}
    
}
