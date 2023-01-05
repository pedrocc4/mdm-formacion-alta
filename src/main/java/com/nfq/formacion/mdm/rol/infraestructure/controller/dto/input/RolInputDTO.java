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
    @NotNull(message = "El campo 'nombreRol' no puede ser nulo")
    private String nombreRol;
    private Date fcAltaRol;
    private Date fcBajaRol;
    @NotNull(message = "El cliente no puede ser nulo al dar de alta un rol")
    private Integer idCliente;
    @NotNull(message = "La poliza no puede ser nula al dar de alta un rol")
    private Integer idPoliza;
}
