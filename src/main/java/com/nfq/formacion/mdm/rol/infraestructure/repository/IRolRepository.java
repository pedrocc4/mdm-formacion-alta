package com.nfq.formacion.mdm.rol.infraestructure.repository;

import com.nfq.formacion.mdm.rol.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
