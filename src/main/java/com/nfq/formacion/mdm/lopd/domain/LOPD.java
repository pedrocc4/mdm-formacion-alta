package com.nfq.formacion.mdm.lopd.domain;

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
public class LOPD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "lopd_generator")
    @TableGenerator(name = "lopd_generator", table = "lopd_generator", pkColumnName = "pk",
            valueColumnName = "next_value", allocationSize = 1, initialValue = 3)
    private int rowidObject;
    @NotNull
    private String valorPublicidad;
    private Date fcModPublicidad;
    private String valorPubElectronica;
    private Date fcModPubElectronica;
    private String valorCesion;
    private Date fcModCesion;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Cliente cliente;
}
