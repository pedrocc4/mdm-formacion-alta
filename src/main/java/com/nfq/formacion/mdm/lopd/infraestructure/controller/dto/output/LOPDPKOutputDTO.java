package com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LOPDPKOutputDTO {
    private int rowidObject;
    @NotNull
    private String valorPublicidad;
    private Date fcModPublicidad;
    private String valorPubElectronica;
    private Date fcModPubElectronica;
    private String valorCesion;
    private Date fcModCesion;
    private int idCliente;
}
