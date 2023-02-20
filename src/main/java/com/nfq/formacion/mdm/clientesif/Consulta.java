package com.nfq.formacion.mdm.clientesif;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonSerialize
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta {
    private String entityType;
    private String search;
    private int recordsToReturn;
}