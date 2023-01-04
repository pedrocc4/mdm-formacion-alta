package com.nfq.formacion.mdm.rol.infraestructure.controller;

import com.nfq.formacion.mdm.rol.domain.Rol;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.input.RolInputDTO;
import com.nfq.formacion.mdm.rol.infraestructure.controller.dto.output.RolOutputDTO;
import com.nfq.formacion.mdm.rol.infraestructure.controller.mapper.IRolMapper;
import com.nfq.formacion.mdm.rol.service.IRolService;
import com.nfq.formacion.mdm.utils.ResponseAlta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.nfq.formacion.mdm.rol.infraestructure.controller.mapper.IRolMapper.INSTANCE;

@RestController
@Slf4j
public class RolController {
    private final IRolService service;

    @Autowired
    public RolController(IRolService service) {
        this.service = service;
    }

    @PostMapping("rol")
    ResponseEntity<ResponseAlta> altaRol(@RequestBody @Valid RolInputDTO rolInputDTO) {
        log.info("Dando de alta: " + rolInputDTO);
        Rol rol = INSTANCE.toEntity(rolInputDTO);
        RolOutputDTO rolOutputDTO = INSTANCE.toDTO(service.altaRol(rol));
        ResponseAlta responseAlta = new ResponseAlta();
        responseAlta.setEntidad(rolOutputDTO);
        responseAlta.setMensaje("El alta ha sido correcta");
        return new ResponseEntity<>(responseAlta, HttpStatus.CREATED);
    }

    @GetMapping("rol/{rowidObject}")
    ResponseEntity<RolOutputDTO> verRol(@PathVariable int rowidObject) {
        log.info("Buscando rol con id: " + rowidObject);
        return new ResponseEntity<>(INSTANCE.toDTO(service.verRol(rowidObject)), HttpStatus.OK);
    }

}
