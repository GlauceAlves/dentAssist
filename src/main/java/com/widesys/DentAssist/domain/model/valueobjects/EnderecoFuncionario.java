package com.widesys.DentAssist.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class EnderecoFuncionario {

	private Long idEndereco;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	private String cep;
	private Integer numero;
	private String complemento;
	
	// tpLograd , dscLograd , nrLograd , complemento , bairro , cep , codMunic , uf 
}
