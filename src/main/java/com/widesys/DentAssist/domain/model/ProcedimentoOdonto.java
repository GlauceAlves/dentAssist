package com.widesys.DentAssist.domain.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedimentoOdonto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProcedimento;
	
	@NotBlank(message = "A descrição não pode ser em branco.")
	private String descricao;

	@ManyToMany(mappedBy = "procedimentosOdonto")
	private List<EspecialidadeOdonto> especialidadesOdonto;
}
