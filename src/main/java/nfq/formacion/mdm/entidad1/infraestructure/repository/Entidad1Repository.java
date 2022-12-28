package nfq.formacion.mdm.entidad1.infraestructure.repository;

import nfq.formacion.mdm.entidad1.domain.Entidad1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entidad1Repository extends JpaRepository<Entidad1, Integer> {
}
