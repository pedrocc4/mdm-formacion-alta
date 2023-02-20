package com.nfq.formacion.mdm.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nfq.formacion.mdm.clientesif.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResponseConsulta extends ResponseAPI {
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("Total records")
    private Integer total;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("Records")
    private List<BaseDTO> entidad;
}
