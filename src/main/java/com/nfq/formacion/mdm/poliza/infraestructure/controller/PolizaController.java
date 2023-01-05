package com.nfq.formacion.mdm.poliza.infraestructure.controller;

import com.nfq.formacion.mdm.poliza.domain.Poliza;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.input.PolizaInputDTO;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.output.PolizaOutputDTO;
import com.nfq.formacion.mdm.poliza.service.IPolizaService;
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

import static com.nfq.formacion.mdm.poliza.infraestructure.controller.mapper.IPolizaMapper.INSTANCE;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_ENTRADA;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_SALIDA_CORRECTA;
import static com.nfq.formacion.mdm.utils.UtilController.respuestaAlta;
import static com.nfq.formacion.mdm.utils.UtilController.validacionRequest;

@RestController
@Slf4j
public class PolizaController {
    private final IPolizaService service;

    @Autowired
    public PolizaController(IPolizaService service) {
        this.service = service;
    }

    @PostMapping("poliza")
    ResponseEntity<ResponseAPI> altaPoliza(@RequestBody @Valid PolizaInputDTO polizaInputDTO,
                                           BindingResult bindingResult) {
        log.info(LOG_ENTRADA + polizaInputDTO);
        if (bindingResult.hasErrors())
            return validacionRequest(bindingResult);
        Poliza poliza = INSTANCE.toEntity(polizaInputDTO);
        PolizaOutputDTO polizaOutputDTO = INSTANCE.toDTO(service.altaPoliza(poliza));
        log.info(LOG_SALIDA_CORRECTA + polizaOutputDTO);
        return new ResponseEntity<>(respuestaAlta(polizaOutputDTO), HttpStatus.CREATED);
    }
}
