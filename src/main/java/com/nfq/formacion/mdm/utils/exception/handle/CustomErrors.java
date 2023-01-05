package com.nfq.formacion.mdm.utils.exception.handle;

import com.nfq.formacion.mdm.utils.exception.NoEncontrado;
import com.nfq.formacion.mdm.utils.response.ResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomErrors extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoEncontrado.class)
    public final ResponseEntity<ResponseAPI> handleUnprocesableEntity(NoEncontrado ex) {
        return new ResponseEntity<>(new ResponseAPI(ex.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }
}