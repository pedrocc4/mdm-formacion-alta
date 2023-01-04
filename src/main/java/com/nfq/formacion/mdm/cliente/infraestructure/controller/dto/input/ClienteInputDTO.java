package com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteInputDTO {
    @NotNull
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    @NotNull
    private String tipoDocumento;
    @NotNull
    private String numeroDocumento;
    private String estadoCivil;
    @NotNull
    private Date fcNacimiento;
}
