package com.nfq.formacion.mdm.rol.infraestructure.controller;

import com.nfq.formacion.mdm.rol.domain.Rol;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.input.RolInputDTO;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.output.RolOutputDTO;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.output.RolPKOutputDTO;
import com.nfq.formacion.mdm.rol.service.IRolService;
import com.nfq.formacion.mdm.utils.response.ResponseAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.nfq.formacion.mdm.rol.infraestructure.controller.mapper.IRolMapper.INSTANCE;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_ENTRADA;
import static com.nfq.formacion.mdm.utils.Constantes.LOG_SALIDA_CORRECTA;
import static com.nfq.formacion.mdm.utils.UtilController.respuestaAlta;
import static com.nfq.formacion.mdm.utils.UtilController.validacionRequest;

@RestController
@Slf4j
public class RolController {
    private final IRolService service;

    @Autowired
    public RolController(IRolService service) {
        this.service = service;
    }

    @PostMapping("rol")
    ResponseEntity<ResponseAPI> altaRol(@RequestBody @Valid RolInputDTO rolInputDTO, BindingResult bindingResult) {
        log.info(LOG_ENTRADA + rolInputDTO);
        if (bindingResult.hasErrors())
            return validacionRequest(bindingResult);
        Rol rol = INSTANCE.toEntity(rolInputDTO);
        RolOutputDTO rolOutputDTO = INSTANCE.toDTO(service.altaRol(rol));
        log.info(LOG_SALIDA_CORRECTA + rolOutputDTO);
        return new ResponseEntity<>(respuestaAlta(rolOutputDTO), HttpStatus.CREATED);
    }

    @GetMapping("rol/{rowidObject}")
    ResponseEntity<RolPKOutputDTO> verRol(@PathVariable int rowidObject) {
        log.info("Buscando rol con id: " + rowidObject);
        return new ResponseEntity<>(INSTANCE.toPKDTO(service.verRol(rowidObject)), HttpStatus.OK);
    }

}
