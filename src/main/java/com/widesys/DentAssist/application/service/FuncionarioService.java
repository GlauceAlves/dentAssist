package com.widesys.DentAssist.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.EspecialidadeOdonto;
import com.widesys.DentAssist.domain.model.Funcionario;
import com.widesys.DentAssist.domain.repository.FuncionarioRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public ResponseEntity<Iterable<Funcionario>> listarFuncionarios() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		if (!funcionarios.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(funcionarios, HttpStatus.OK);
	}

	public Funcionario buscarFuncionarioPorId(Long id) { 
	    return funcionarioRepository.findById(id)
	                               .orElseThrow(() -> new NotFoundException("Funcionário não encontrado com ID: " + id));
	}

	
	public ResponseEntity<String> registraFuncionario(Funcionario funcionario) {
	    if (funcionario.getCpf() == null || funcionario.getCpf().isEmpty()) {
	        return new ResponseEntity<>("CPF não pode ser vazio.", HttpStatus.BAD_REQUEST);  
	    }
	    if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
	        return new ResponseEntity<>("CPF já cadastrado.", HttpStatus.CONFLICT);  
	    }
		if (funcionario.getFuncao() == null || funcionario.getFuncao().getDescricao() == null || funcionario.getFuncao().getDescricao().isEmpty()) {
			return new ResponseEntity<>("Função não pode ser vazio.", HttpStatus.BAD_REQUEST);
		}
		if (funcionario.getEspecialidadesOdonto() == null | funcionario.getEspecialidadesOdonto().getFirst().getDescricao().isEmpty()) {
			return new ResponseEntity<>("Informe uma especialidade.", HttpStatus.BAD_REQUEST);
		}
		
	    funcionarioRepository.save(funcionario);
	    return new ResponseEntity<>("Funcionário registrado com sucesso", HttpStatus.CREATED);  
	}
 
//    public void verificarEspecialidadesRegistradas(List<EspecialidadeOdonto> especialidades) {
//        List<Long> idsEspecialidadesNaoRegistradas = especialidades.stream()
//            .filter(especialidade -> !especialidadeOdontoRepository.existsById(especialidade.getId()))
//            .map(EspecialidadeOdonto::getId)
//            .collect(Collectors.toList());
//
//        if (!idsEspecialidadesNaoRegistradas.isEmpty()) {
//            throw new NotFoundException("As especialidades com IDs " + idsEspecialidadesNaoRegistradas + " não estão registradas no banco.");
//        }
//    }
}
