package com.nfq.formacion.mdm.rol.infraestructure.controller.mapper;

import com.nfq.formacion.mdm.rol.domain.Rol;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.input.RolInputDTO;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.output.RolOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Mapper
@Validated
public interface IRolMapper {
    IRolMapper INSTANCE = Mappers.getMapper(IRolMapper.class);

    @Mapping(source = "fk_cliente", target = "cliente.rowidObject")
    Rol toEntity(@Valid RolInputDTO rolInputDTO);

    @Valid RolOutputDTO toDTO(Rol rol);

}
