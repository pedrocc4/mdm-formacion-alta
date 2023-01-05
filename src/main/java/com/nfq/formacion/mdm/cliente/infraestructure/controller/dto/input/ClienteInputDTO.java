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
    @NotNull(message = "El campo 'nombre' no puede ser nulo")
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    @NotNull(message = "El campo 'tipoDocumento' no puede ser nulo")
    private String tipoDocumento;
    @NotNull(message = "El campo 'numeroDocumento' no puede ser nulo")
    private String numeroDocumento;
    private String estadoCivil;
    @NotNull
    private Date fcNacimiento;
}
