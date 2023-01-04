package com.nfq.formacion.mdm.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TimeOutException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    private final String descriptionMessage;
}

