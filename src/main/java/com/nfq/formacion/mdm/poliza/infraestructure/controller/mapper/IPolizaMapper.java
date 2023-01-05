package com.nfq.formacion.mdm.poliza.infraestructure.controller.mapper;

import com.nfq.formacion.mdm.poliza.domain.Poliza;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.input.PolizaInputDTO;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.output.PolizaOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Mapper
@Validated
public interface IPolizaMapper {
    IPolizaMapper INSTANCE = Mappers.getMapper(IPolizaMapper.class);

    @Mapping(target = "rowidObject", ignore = true)
    Poliza toEntity(@Valid PolizaInputDTO polizaInputDTO);

    @Valid PolizaOutputDTO toDTO(Poliza poliza);

}
