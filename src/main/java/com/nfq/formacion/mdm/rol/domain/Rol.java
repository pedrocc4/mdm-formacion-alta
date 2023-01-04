package com.nfq.formacion.mdm.rol.domain;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rowidObject;
    @NotNull
    private String rol;
    private Date fcAltaRol;
    private Date fcBajaRol;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Cliente cliente;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    private Poliza idPoliza;
}
