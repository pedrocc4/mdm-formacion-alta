package com.nfq.formacion.mdm.cliente.infraestructure.controller.mapper;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.input.ClienteInputDTO;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.output.ClienteOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Mapper
@Validated
public interface IClienteMapper {
    IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

    Cliente toEntity(@Valid ClienteInputDTO clienteInputDTO);

    @Valid ClienteOutputDTO toDTO(Cliente cliente);

}
