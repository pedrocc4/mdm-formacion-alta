package com.nfq.formacion.mdm.lopd.infraestructure.controller;

import com.nfq.formacion.mdm.lopd.domain.LOPD;
import com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.input.LOPDInputDTO;
import com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.output.LOPDOutputDTO;
import com.nfq.formacion.mdm.lopd.infraestructure.controller.dto.output.LOPDPKOutputDTO;
import com.nfq.formacion.mdm.lopd.service.ILOPDService;
import com.nfq.formacion.mdm.utils.response.ResponseAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.nfq.formacion.mdm.lopd.infraestructure.controller.mapper.ILOPDMapper.INSTANCE;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_ENTRADA;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_SALIDA_CORRECTA;
import static com.nfq.formacion.mdm.utils.UtilController.respuestaAlta;
import static com.nfq.formacion.mdm.utils.UtilController.validacionRequest;

@RestController
@Slf4j
public class LOPDController {
    private final ILOPDService service;

    @Autowired
    public LOPDController(ILOPDService service) {
        this.service = service;
    }

    @PostMapping("lopd")
    ResponseEntity<ResponseAPI> altaRol(@RequestBody @Valid LOPDInputDTO lopdInputDTO, BindingResult bindingResult) {
        log.info(LOG_ENTRADA + lopdInputDTO);
        if (bindingResult.hasErrors())
            return validacionRequest(bindingResult);
        LOPD lopd = INSTANCE.toEntity(lopdInputDTO);
        LOPDOutputDTO lopdOutputDTO = INSTANCE.toDTO(service.altaLOPD(lopd));
        log.info(LOG_SALIDA_CORRECTA + lopdOutputDTO);
        return new ResponseEntity<>(respuestaAlta(lopdOutputDTO), HttpStatus.CREATED);
    }

    @GetMapping("lopd/{rowidObject}")
    ResponseEntity<LOPDPKOutputDTO> verRol(@PathVariable int rowidObject) {
        log.info("Buscando rol con id: " + rowidObject);
        return new ResponseEntity<>(INSTANCE.toPKDTO(service.verLOPD(rowidObject)), HttpStatus.OK);
    }

}
