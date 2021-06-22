package kma.practice.eambulance.entity;

import kma.practice.eambulance.database.entities.Authority;
import kma.practice.eambulance.database.entities.CallEntity;
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
public class AuthorityTest {

    private static Authority validAuthority;

    @BeforeAll
    static void init(){
        validAuthority = new Authority();
        validAuthority.setName("New One");
        validAuthority.setId((long)4);
    }

    @Test
    void createValidCall() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Authority>> violations = validator.validate(validAuthority);
        assertEquals(0, violations.size());
    }

}
