package com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LOPDInputDTO {
    @NotNull(message = "El campo 'valorPublicidad' no puede ser nulo")
    private String valorPublicidad;
    private Date fcModPublicidad;
    private String valorPubElectronica;
    private Date fcModPubElectronica;
    private String valorCesion;
    private Date fcModCesion;
    @NotNull(message = "El cliente no puede ser nulo al dar de alta un indicador LOPD")
    private Integer idCliente;
}
