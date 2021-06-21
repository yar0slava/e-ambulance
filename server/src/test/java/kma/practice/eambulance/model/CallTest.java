package kma.practice.eambulance.model;


import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.database.entities.CallStatus;
import kma.practice.eambulance.database.entities.CrewEntity;
import kma.practice.eambulance.database.entities.DispatcherEntity;

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
public class CallTest {

    private static CallEntity validCallEntity;


    @BeforeAll
    static void init(){

        DispatcherEntity validDispatcherEntity = new DispatcherEntity();
        validDispatcherEntity.setTabNumber(123456789);

        CrewEntity validCrewEntity = new CrewEntity();
        validCrewEntity.setTabNumber(123456798);

        validCallEntity = new CallEntity();

        validCallEntity.setStatus(CallStatus.WAITING_FOR_CREW);
        validCallEntity.setReport("none");
        validCallEntity.setPatientCondition("unstable");
        validCallEntity.setPhoneNumber("0632459854");

        validCallEntity.setCrew(validCrewEntity);
        validCallEntity.setDispatcher(validDispatcherEntity);

    }

    @Test
    void createValidCall() {

        validCallEntity.setReason("Heart attack");
        validCallEntity.setAddress("Nezalezhnosti str. 25, flat 16");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CallEntity>> violations = validator.validate(validCallEntity);

        assertEquals(0, violations.size());
    }

    @Test
    void constraintViolationInvalidReason(){

        validCallEntity.setReason("oy");
        validCallEntity.setAddress("Nezalezhnosti str. 25, flat 16");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CallEntity>> violations = validator.validate(validCallEntity);

        assertEquals(1, violations.size());

    }

    @Test
    void constraintViolationAddress(){

        validCallEntity.setReason("oy");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CallEntity>> violations = validator.validate(validCallEntity);

        assertEquals(1, violations.size());

    }


}
