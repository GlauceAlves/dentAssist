package com.widesys.DentAssist.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widesys.DentAssist.domain.model.EspecialidadeOdonto;
import com.widesys.DentAssist.domain.model.Funcionario;
import com.widesys.DentAssist.domain.repository.EspecialidadeOdontoRepository;
import com.widesys.DentAssist.domain.repository.FuncaoFuncionarioRepository;
import com.widesys.DentAssist.domain.repository.FuncionarioRepository;
import com.widesys.DentAssist.web.controller.exception.NotFoundException;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private final EspecialidadeOdontoRepository especialidadeOdontoRepository;
	private final FuncaoFuncionarioRepository funcaoFuncionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository,
			EspecialidadeOdontoRepository especialidadeOdontoRepository,
			FuncaoFuncionarioRepository funcaoFuncionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.especialidadeOdontoRepository = especialidadeOdontoRepository;
		this.funcaoFuncionarioRepository = funcaoFuncionarioRepository;

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
		ResponseEntity<String> validaResponse = validaFuncionario(funcionario);
		if (validaResponse.getStatusCode() != HttpStatus.OK) {
			return validaResponse;
		}
		List<EspecialidadeOdonto> especialidades = funcionario.getEspecialidadesOdonto();
		ResponseEntity<String> verificaResponse = verificarEspecialidadesRegistradas(especialidades);
		if (verificaResponse.getStatusCode() != HttpStatus.OK) {
			return verificaResponse;
		}
		
		funcionarioRepository.save(funcionario);
		return new ResponseEntity<>("Funcionário registrado com sucesso", HttpStatus.CREATED);
	}
	

	public ResponseEntity<String> validaFuncionario(Funcionario funcionario) {
		if (funcionario.getCpf() == null || funcionario.getCpf().isEmpty()) {
			return new ResponseEntity<>("CPF não pode ser vazio.", HttpStatus.BAD_REQUEST);
		}
		if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
			return new ResponseEntity<>("CPF já cadastrado.", HttpStatus.CONFLICT);
		}
		if (funcionario.getFuncao() == null || funcionario.getFuncao().getIdFuncao() == null) {
			return new ResponseEntity<>("Função não pode ser vazio.", HttpStatus.BAD_REQUEST);
		}
		if (!funcaoFuncionarioRepository.findById(funcionario.getFuncao().getIdFuncao()).isPresent()) {
			return new ResponseEntity<>("Função não registrada.", HttpStatus.BAD_REQUEST);
		}
		if (funcionario.getEspecialidadesOdonto() == null
				|| funcionario.getEspecialidadesOdonto().get(0).getIdEspecialidade() == null) {
			return new ResponseEntity<>("Informe uma especialidade.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Funcionário OK.", HttpStatus.OK);
	}
	
	

	public ResponseEntity<String> verificarEspecialidadesRegistradas(List<EspecialidadeOdonto> especialidades) {
		List<Long> idsEspecialidadesNaoRegistradas = especialidades
				.stream().filter(especialidade -> !especialidadeOdontoRepository
						.findById(especialidade.getIdEspecialidade()).isPresent())
				.map(EspecialidadeOdonto::getIdEspecialidade).collect(Collectors.toList());

	    if (!idsEspecialidadesNaoRegistradas.isEmpty()) {
	        String mensagem = "As especialidades com IDs " + idsEspecialidadesNaoRegistradas + " não estão registradas no banco.";
	        return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
	    }
	    return new ResponseEntity<>("Especialidades Ok", HttpStatus.OK);
	}

 
	 
}
