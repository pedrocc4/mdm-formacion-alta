package com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.output;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nfq.formacion.mdm.clientesif.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PolizaOutputDTO extends BaseDTO {
    @NotNull
    @JsonAlias("poliza.poliza")
    @JsonProperty("numPoliza")
    private String numPoliza;
    @JsonAlias("poliza.contrato")
    @JsonProperty("numContrato")
    private String numContrato;
    @JsonAlias("poliza.orden")
    @JsonProperty("numOrden")
    private String numOrden;
    @JsonAlias("poliza.fecha_inicio_vigencia")
    @JsonProperty("fcInicioVigencia")
    private LocalDate fcInicioVigencia;
    @JsonAlias("poliza.fecha_vencimiento")
    @JsonProperty("fcFinVigencia")
    private LocalDate fcFinVigencia;
}
