package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.CrewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrewsRepository extends JpaRepository<CrewEntity, Long> {

    Optional<CrewEntity> findByCredentials_Login(String login);
}
