package com.widesys.DentAssist.domain.model.util;

import com.widesys.DentAssist.domain.model.valueobjects.TipoEnderecoEnum;

public class ValidadorTipoEndereco {
    public static boolean isValidTipoEndereco(String tipoEnderecoString) {
        try {
            TipoEnderecoEnum.valueOf(tipoEnderecoString.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
