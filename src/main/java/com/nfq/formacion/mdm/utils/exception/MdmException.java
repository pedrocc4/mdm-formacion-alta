package com.nfq.formacion.mdm.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MdmException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    private final String descriptionMessage;
    private final String codigo;
}