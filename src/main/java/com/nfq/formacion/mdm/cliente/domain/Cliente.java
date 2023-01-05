package com.nfq.formacion.mdm.cliente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cliente_generator")
    @TableGenerator(name = "cliente_generator", table = "cliente_generator", pkColumnName = "pk",
            valueColumnName = "next_value", allocationSize = 1, initialValue = 3)
    private int rowidObject;
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
