package com.nfq.formacion.mdm.poliza.domain;

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
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "poliza_generator")
    @TableGenerator(name = "poliza_generator", table = "poliza_generator", pkColumnName = "pk",
            valueColumnName = "next_value", allocationSize = 1, initialValue = 3)
    private int rowidObject;
    @NotNull
    private String numPoliza;
    private String numContrato;
    private String numOrden;
    private Date fcInicioVigencia;

    private Date fcFinVigencia;
}
