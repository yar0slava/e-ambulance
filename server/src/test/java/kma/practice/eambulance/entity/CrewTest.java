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
public class CrewTest {

    private static CrewEntity validCrewEntity;

    @BeforeAll
    static void init(){

        Authority authority = new Authority();
        authority.setId((long) 3);


        CredentialsEntity validCredentialsEntity = new CredentialsEntity();
        validCredentialsEntity.setLogin("test@gmai.com");
        validCredentialsEntity.setPassword("test1234");
        validCredentialsEntity.setAuthority(authority);

        validCrewEntity = new CrewEntity();
        validCrewEntity.setCredentials(validCredentialsEntity);


    }

    @Test
    void createValidCrew() {

        validCrewEntity.setCarNumber("4567");
        validCrewEntity.setMembers("John");
        validCrewEntity.setAvailability(Availability.AVAILABLE);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CrewEntity>> violations = validator.validate(validCrewEntity);
        assertEquals(0, violations.size());
    }

    @Test
    void constraintViolationInvalidCarNumber(){

        validCrewEntity.setCarNumber("11111111");
        validCrewEntity.setMembers("John");
        validCrewEntity.setAvailability(Availability.AVAILABLE);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CrewEntity>> violations = validator.validate(validCrewEntity);
        assertEquals(1, violations.size());

    }

    @Test
    void constraintViolationWithNullMembers(){

        validCrewEntity.setCarNumber("6789");
        validCrewEntity.setMembers("");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CrewEntity>> violations = validator.validate(validCrewEntity);
        assertEquals(1, violations.size());

    }


}
