package com.nfq.formacion.mdm.rol.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolInputDTO {
    @NotNull
    private String rol;
    private Date fcAltaRol;
    private Date fcBajaRol;
    private int fk_cliente;
}
