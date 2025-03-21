package com.widesys.DentAssist.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeOdonto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspecialidade;
	private String descricao;

	@ManyToMany
    @JoinTable(
            name = "especialidades_odonto_procedimentos_odonto",
            joinColumns = @JoinColumn(name = "idEspecialidade"),  
            inverseJoinColumns = @JoinColumn(name = "idProcedimento")  
        )	
	
	private List<ProcedimentoOdonto> procedimentosOdonto;
	
	@ManyToMany(mappedBy = "especialidadesOdonto")
	private List<Funcionario> funcionarios;
}
