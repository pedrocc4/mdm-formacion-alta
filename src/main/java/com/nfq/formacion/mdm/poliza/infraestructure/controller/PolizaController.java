package com.nfq.formacion.mdm.poliza.infraestructure.controller;

import com.nfq.formacion.mdm.poliza.domain.Poliza;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.input.PolizaInputDTO;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.output.PolizaOutputDTO;
import com.nfq.formacion.mdm.poliza.service.IPolizaService;
import com.nfq.formacion.mdm.utils.ResponseAlta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.nfq.formacion.mdm.poliza.infraestructure.controller.mapper.IPolizaMapper.INSTANCE;

@RestController
@Slf4j
public class PolizaController {
    private final IPolizaService service;

    @Autowired
    public PolizaController(IPolizaService service) {
        this.service = service;
    }

    @PostMapping("cliente")
    ResponseEntity<ResponseAlta> altaCliente(@RequestBody @Valid PolizaInputDTO polizaInputDTO) {
        log.info("Dando de alta: " + polizaInputDTO);
        Poliza poliza = INSTANCE.toEntity(polizaInputDTO);
        PolizaOutputDTO polizaOutputDTO = INSTANCE.toDTO(service.altaPoliza(poliza));
        ResponseAlta responseAlta = new ResponseAlta();
        responseAlta.setEntidad(polizaOutputDTO);
        responseAlta.setMensaje("El alta ha sido correcta");
        return new ResponseEntity<>(responseAlta, HttpStatus.OK);
    }
}
