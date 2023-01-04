package com.nfq.formacion.mdm.cliente.infraestructure.repository;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    boolean existsByRowidObject(int rowidObject);
}
