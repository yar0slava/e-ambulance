package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.CrewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewsRepository extends JpaRepository<CrewEntity, Long> {
}
