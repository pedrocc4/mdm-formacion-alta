package com.nfq.formacion.mdm.lopd.infraestructure.repository;

import com.nfq.formacion.mdm.lopd.domain.LOPD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILOPDRepository extends JpaRepository<LOPD, Integer> {
}
