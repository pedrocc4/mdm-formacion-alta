package com.nfq.formacion.mdm.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoEncontrado extends RuntimeException {
    public NoEncontrado(String message) {
        super(message);
    }
}
