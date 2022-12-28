package nfq.formacion.mdm.entidad1.infraestructure.controller;

import nfq.formacion.mdm.utils.ResponseAlta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Entidad1Controller {
    @PostMapping("entidad1")
    ResponseEntity<ResponseAlta> altaEntidad1() {
        return new ResponseEntity<>(new ResponseAlta(), HttpStatus.OK);
    }
}
