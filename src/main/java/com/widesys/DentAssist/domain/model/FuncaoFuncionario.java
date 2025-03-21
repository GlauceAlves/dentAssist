package com.widesys.DentAssist.domain.model;

 

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncaoFuncionario {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFuncao;
	private String descricao;
	
	@OneToMany(mappedBy="funcao")
	private List<Funcionario> funcionarios;
	

	

}
