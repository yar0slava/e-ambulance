package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.CallEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallsRepository extends JpaRepository<CallEntity, Long> {

    List<CallEntity> findByCrew_TabNumber(long tabNumber, Sort sort);
}
