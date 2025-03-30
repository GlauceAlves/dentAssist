package com.widesys.DentAssist.domain.model.util;

public class ValidadorCpf {
    public static boolean validarCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        
        return cpf.matches("\\d{11}");
    }

}
