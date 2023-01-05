package com.nfq.formacion.mdm.utils;

import com.nfq.formacion.mdm.utils.response.ResponseAPI;
import com.nfq.formacion.mdm.utils.response.ResponseAlta;
import com.nfq.formacion.mdm.utils.response.RespuestaError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

import static com.nfq.formacion.mdm.utils.Constantes.ALTA_CORRECTA;

public class UtilController {
    private UtilController() {
    }

    public static ResponseAlta respuestaAlta(Object entidad) {
        ResponseAlta responseAlta = new ResponseAlta(entidad);
        responseAlta.setMensaje(ALTA_CORRECTA);
        return responseAlta;
    }

    public static ResponseEntity<ResponseAPI> validacionRequest(BindingResult bindingResult) {
        List<String> mensajes = bindingResult.getAllErrors().stream()
                .filter(FieldError.class::isInstance)
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        RespuestaError respuestaError = new RespuestaError(mensajes);
        respuestaError.setMensaje("Fallo en la validación de los datos");
        return new ResponseEntity<>(respuestaError, HttpStatus.BAD_REQUEST);
    }
}
