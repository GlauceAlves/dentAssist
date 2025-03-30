package com.widesys.DentAssist.domain.model.util;

public class ValidacoesComuns {
	
	  public static boolean validarCpf(String cpf) {
	 
	        return ValidadorCpf.validarCpf(cpf);
	    }

	    public static boolean validarEmail(String email) {
	        
	        return email != null && email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	    }


}
