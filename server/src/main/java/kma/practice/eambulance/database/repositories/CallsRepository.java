package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.CallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallsRepository extends JpaRepository<CallEntity, Long> {


}
