package com.nfq.formacion.mdm.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPI {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Mensaje")
    private String mensaje;
}
