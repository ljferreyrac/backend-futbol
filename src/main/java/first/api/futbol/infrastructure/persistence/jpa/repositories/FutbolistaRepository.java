package first.api.futbol.infrastructure.persistence.jpa.repositories;

import first.api.futbol.domain.model.entities.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutbolistaRepository extends JpaRepository<Futbolista, Long> {
}
