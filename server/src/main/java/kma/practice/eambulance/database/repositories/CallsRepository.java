package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.CallEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CallsRepository extends CrudRepository<CallEntity,Long> {

    List<CallEntity> findByDateTime(LocalDateTime dateTime);

    List<CallEntity> findByCrew_TabNumber(Long tabNumber);
}
