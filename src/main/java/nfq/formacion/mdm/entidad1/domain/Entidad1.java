package nfq.formacion.mdm.entidad1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
public class Entidad1 { //TODO definir entidades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size
    private String nombre;
    @Size
    private String otro;
}
