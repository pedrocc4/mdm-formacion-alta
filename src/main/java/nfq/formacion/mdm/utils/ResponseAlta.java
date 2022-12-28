package nfq.formacion.mdm.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseAlta { //FIXME buscar forma de ignorar errores si entidad = null y viceversa
    //FIXME igual no es necesario y podemos hacerlo en el output
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Errores de validación")
    private String error;
    @JsonProperty("Mensaje")
    private String mensaje;
    @JsonProperty("Datos entidad")
    private Object entidad;

}
