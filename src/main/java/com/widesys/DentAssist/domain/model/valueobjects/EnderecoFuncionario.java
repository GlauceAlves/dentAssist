package com.widesys.DentAssist.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class EnderecoFuncionario {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Enumerated(EnumType.STRING)
	private TipoEnderecoEnum tipoEndereco;
	private String cep;
	private Integer numero;
	private String complemento;
	
	// tpLograd , dscLograd , nrLograd , complemento , bairro , cep , codMunic , uf 
}
