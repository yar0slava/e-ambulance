package kma.practice.eambulance.repository;

import kma.practice.eambulance.database.entities.Authority;
import kma.practice.eambulance.database.repositories.AuthorityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AuthorityRepositoryTest {

    @Autowired
    private static AuthorityRepository authorityRepository;

    @Test
    public void createValidCall(){


        Authority authority = new Authority();
        authority.setId((long)3456);
        authority.setName("Test");

        Authority saveAuthority;
        saveAuthority = authorityRepository.save(authority);

        assertEquals("Test",saveAuthority.getName());

    }


}
