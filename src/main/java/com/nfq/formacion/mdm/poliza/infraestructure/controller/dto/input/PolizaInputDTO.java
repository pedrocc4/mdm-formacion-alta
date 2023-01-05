package com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolizaInputDTO {
    @NotNull(message = "El campo 'numPoliza' no puede ser nulo")
    private String numPoliza;
    private String numContrato;
    private String numOrden;
    private Date fcInicioVigencia;

    private Date fcFinVigencia;
}
