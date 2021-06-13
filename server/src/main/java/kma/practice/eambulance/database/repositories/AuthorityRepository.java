package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    Optional<Authority> findByLogin(String login);

    Optional<Authority> findById(Long id);
}
