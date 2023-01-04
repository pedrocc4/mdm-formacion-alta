package com.nfq.formacion.mdm.rol.infraestructure.controller.dto.output;

import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.output.ClienteOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RolOutputDTO {
    private int rowidObject;
    @NotNull
    private String rol;
    private Date fcAltaRol;
    private Date fcBajaRol;
    private ClienteOutputDTO cliente;
}
