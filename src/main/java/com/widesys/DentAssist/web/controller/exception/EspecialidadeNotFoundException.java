package com.widesys.DentAssist.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus ( value=HttpStatus.NOT_FOUND, reason = "Especialidade não encontrada.")
public class EspecialidadeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4840047080846927768L;
 

	public EspecialidadeNotFoundException(String message) {
		super(message);
	}
}
