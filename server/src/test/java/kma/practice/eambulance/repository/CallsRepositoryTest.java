package kma.practice.eambulance.repository;

import kma.practice.eambulance.database.entities.*;
import kma.practice.eambulance.database.repositories.CallsRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CallsRepositoryTest {

    private static CrewEntity crewDto;
    private static DispatcherEntity dispatcherDto;
    private static CredentialsEntity credentialsDto;
    private static Authority authority;
    private static CrewEntity crewEntity;

    @Autowired
    private static CallsRepository callsRepository;

    @BeforeAll
    static void init(){

        authority = new Authority();
        authority.setId((long)3);
        authority.setName("TestAuthority");

        credentialsDto = new CredentialsEntity();
        credentialsDto.setLogin("456789");
        credentialsDto.setLogin("test@gmail.com");
        credentialsDto.setAuthority(authority);

        dispatcherDto = new DispatcherEntity();
        dispatcherDto.setTabNumber(34);
        dispatcherDto.setCredentials(credentialsDto);

        crewEntity = new CrewEntity();
        crewEntity.setAvailability(Availability.AVAILABLE);
        crewEntity.setCredentials(credentialsDto);
        crewEntity.setMembers("test");
        crewEntity.setCarNumber("4567");
        crewEntity.setLocation("Test");
        crewEntity.setTabNumber(5678);



    }

    @Test
    public void createValidCall(){

        CallEntity callEntity = new CallEntity();
        callEntity.setReport("test");
        callEntity.setDispatcher(dispatcherDto);
        callEntity.setPhoneNumber("0970046758");
        callEntity.setCrew(crewEntity);
        callEntity.setReason("Broke");
        callEntity.setAddress("testtest");

        CallEntity savedCall = callsRepository.save(callEntity);
        System.out.println(savedCall.getDateTime());

        assertEquals("0970046758","0970046758");
    }






}
