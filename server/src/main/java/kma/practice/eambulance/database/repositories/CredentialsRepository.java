package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Long> {

    Optional<CredentialsEntity> findByLogin(String login);
}
