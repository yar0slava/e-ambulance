package kma.practice.eambulance.database.repositories;

import kma.practice.eambulance.database.entities.DispatcherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DispatchersRepository extends JpaRepository<DispatcherEntity, Long>{

    @Query("SELECT d FROM DispatcherEntity d WHERE d.credentials.login = ?1")
    DispatcherEntity findByCredentials_Login(@Param("login")  String login);
}

