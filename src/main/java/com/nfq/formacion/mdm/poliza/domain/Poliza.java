package com.nfq.formacion.mdm.poliza.domain;

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
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rowidObject;
    @NotNull
    private String numPoliza;
    private String numContrato;
    private String numOrden;
    private Date fcInicioVigencia;

    private Date fcFinVigencia;
}
