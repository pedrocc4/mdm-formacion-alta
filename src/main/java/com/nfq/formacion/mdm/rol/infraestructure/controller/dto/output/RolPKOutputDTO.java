package com.nfq.formacion.mdm.rol.infraestructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RolPKOutputDTO {
    private int rowidObject;
    @NotNull
    private String nombreRol;
    private Date fcAltaRol;
    private Date fcBajaRol;
    private int idCliente;
    private int idPoliza;
}
