package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.DispatcherEntity;
import org.springframework.data.repository.CrudRepository;

public interface DispatchersRepository extends CrudRepository<DispatcherEntity, Long> {
}
