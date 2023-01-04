package com.nfq.formacion.mdm.cliente.infraestructure.controller;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.input.ClienteInputDTO;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.output.ClienteOutputDTO;
import com.nfq.formacion.mdm.cliente.service.IClienteService;
import com.nfq.formacion.mdm.utils.ResponseAlta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.nfq.formacion.mdm.cliente.infraestructure.controller.mapper.IClienteMapper.INSTANCE;

@RestController
@Slf4j
public class ClienteController {
    private final IClienteService service;

    @Autowired
    public ClienteController(IClienteService service) {
        this.service = service;
    }

    @PostMapping("cliente")
    ResponseEntity<ResponseAlta> altaCliente(@RequestBody @Valid ClienteInputDTO clienteInputDTO) {
        log.info("Dando de alta: " + clienteInputDTO);
        Cliente cliente = INSTANCE.toEntity(clienteInputDTO);
        ClienteOutputDTO clienteOutputDTO = INSTANCE.toDTO(service.altaCliente(cliente));
        ResponseAlta responseAlta = new ResponseAlta();
        responseAlta.setEntidad(clienteOutputDTO);
        responseAlta.setMensaje("El alta ha sido correcta");
        return new ResponseEntity<>(responseAlta, HttpStatus.OK);
    }
}
