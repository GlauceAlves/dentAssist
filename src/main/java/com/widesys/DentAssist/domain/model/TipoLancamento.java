package com.widesys.DentAssist.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.widesys.DentAssist.domain.model.valueobjects.TipoLancamentoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoLancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoLancamento;
	private String descricao;
	
	
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private TipoLancamentoEnum tipoLancamento;
}
