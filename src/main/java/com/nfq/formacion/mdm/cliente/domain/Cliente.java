package com.nfq.formacion.mdm.cliente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
