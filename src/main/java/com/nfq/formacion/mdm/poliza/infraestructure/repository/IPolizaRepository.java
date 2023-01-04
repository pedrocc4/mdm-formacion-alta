package com.nfq.formacion.mdm.poliza.infraestructure.repository;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.poliza.domain.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPolizaRepository extends JpaRepository<Poliza, Integer> {
}
