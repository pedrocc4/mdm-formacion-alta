package com.nfq.formacion.mdm.lopd.infraestructure.controller.mapper;

import com.nfq.formacion.mdm.lopd.domain.LOPD;
import com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.input.LOPDInputDTO;
import com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.output.LOPDOutputDTO;
import com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.output.LOPDPKOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Mapper
@Validated
public interface ILOPDMapper {
    ILOPDMapper INSTANCE = Mappers.getMapper(ILOPDMapper.class);

    @Mapping(source = "idCliente", target = "cliente.rowidObject")
    LOPD toEntity(@Valid LOPDInputDTO lopdInputDTO);

    @Valid LOPDOutputDTO toDTO(LOPD lopd);

    @Mapping(source = "cliente.rowidObject", target = "idCliente")
    @Valid LOPDPKOutputDTO toPKDTO(LOPD lopd);
}
