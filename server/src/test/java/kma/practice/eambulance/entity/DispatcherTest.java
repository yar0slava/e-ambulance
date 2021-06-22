package kma.practice.eambulance.entity;

import kma.practice.eambulance.database.entities.*;
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
public class DispatcherTest {

    private static DispatcherEntity validDispatcherEntity;

    @BeforeAll
    static void init(){

        Authority authority = new Authority();
        authority.setId((long) 3);

        CredentialsEntity validCredentialsEntity = new CredentialsEntity();
        validCredentialsEntity.setLogin("test@gmai.com");
        validCredentialsEntity.setPassword("test1234");
        validCredentialsEntity.setAuthority(authority);

        validDispatcherEntity = new DispatcherEntity();
        validDispatcherEntity.setFullName("Test");
        validDispatcherEntity.setTabNumber(3456789);
        validDispatcherEntity.setCredentials(validCredentialsEntity);


    }

    @Test
    void createValidDispatcher() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<DispatcherEntity>> violations = validator.validate(validDispatcherEntity);
        assertEquals(0, violations.size());
    }


}
