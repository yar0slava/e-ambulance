package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.DispatcherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<DispatcherEntity, Long> {

}

