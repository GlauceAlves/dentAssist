package com.widesys.DentAssist.domain.model.util;

import com.widesys.DentAssist.domain.model.valueobjects.TipoEndereco;

public class ValidadorTipoEndereco {
    public static boolean isValidTipoEndereco(String tipoEnderecoString) {
        try {
            TipoEndereco.valueOf(tipoEnderecoString.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
