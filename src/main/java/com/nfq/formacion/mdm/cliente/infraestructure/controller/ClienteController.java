package com.nfq.formacion.mdm.cliente.infraestructure.controller;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.input.ClienteInputDTO;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.output.ClienteOutputDTO;
import com.nfq.formacion.mdm.cliente.service.IClienteService;
import com.nfq.formacion.mdm.utils.response.ResponseAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.nfq.formacion.mdm.cliente.infraestructure.controller.mapper.IClienteMapper.INSTANCE;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_ENTRADA;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_SALIDA_CORRECTA;
import static com.nfq.formacion.mdm.utils.UtilController.respuestaAlta;
import static com.nfq.formacion.mdm.utils.UtilController.validacionRequest;

@RestController
@Slf4j
public class ClienteController {
    private final IClienteService service;

    @Autowired
    public ClienteController(IClienteService service) {
        this.service = service;
    }

    @PostMapping("cliente")
    ResponseEntity<ResponseAPI> altaCliente(@RequestBody @Valid ClienteInputDTO clienteInputDTO,
                                            BindingResult bindingResult) {
        log.info(LOG_ENTRADA + clienteInputDTO);
        if (bindingResult.hasErrors())
            return validacionRequest(bindingResult);
        Cliente cliente = INSTANCE.toEntity(clienteInputDTO);
        ClienteOutputDTO clienteOutputDTO = INSTANCE.toDTO(service.altaCliente(cliente));
        log.info(LOG_SALIDA_CORRECTA + clienteOutputDTO);
        return new ResponseEntity<>(respuestaAlta(clienteOutputDTO), HttpStatus.CREATED);
    }
}
