package com.nfq.formacion.mdm.utils.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResponseAlta extends ResponseAPI {
    @JsonProperty("Datos entidad")
    private Object entidad;
}
