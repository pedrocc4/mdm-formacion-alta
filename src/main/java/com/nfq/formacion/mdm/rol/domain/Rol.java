package com.nfq.formacion.mdm.rol.domain;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.poliza.domain.Poliza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rol_generator")
    @TableGenerator(name = "rol_generator", table = "rol_generator", pkColumnName = "pk",
            valueColumnName = "next_value", allocationSize = 1, initialValue = 3)
    private int rowidObject;
    @NotNull
    private String nombreRol;
    private Date fcAltaRol;
    private Date fcBajaRol;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Poliza poliza;
}
