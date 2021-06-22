package kma.practice.eambulance.entity;

import kma.practice.eambulance.database.entities.Authority;
import kma.practice.eambulance.database.entities.CredentialsEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CredentialsTest {

    private static CredentialsEntity validCredentialsEntity;

    @BeforeAll
    static void init(){

        Authority authority = new Authority();
        authority.setId((long) 3);

        validCredentialsEntity = new CredentialsEntity();
        validCredentialsEntity.setAuthority(authority);

    }

    @Test
    void createValidCredentials() {

        validCredentialsEntity.setPassword("1234567");
        validCredentialsEntity.setLogin("test@gmai.com");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CredentialsEntity>> violations = validator.validate(validCredentialsEntity);
        assertEquals(0, violations.size());
    }

    @Test
    void createViolationInvalidLogin() {

        validCredentialsEntity.setPassword("1234567");
        validCredentialsEntity.setLogin("test");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CredentialsEntity>> violations = validator.validate(validCredentialsEntity);
        assertEquals(1, violations.size());
    }

    @Test
    void createViolationNullPassword() {

        validCredentialsEntity.setPassword("");
        validCredentialsEntity.setLogin("test@gmail.com");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CredentialsEntity>> violations = validator.validate(validCredentialsEntity);
        assertEquals(1, violations.size());
    }


}
