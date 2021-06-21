package kma.practice.eambulance.repository;

import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.database.repositories.CallsRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CallsRepositoryTest {

    @Autowired
    CallsRepository callsRepository;

    @Test
    public void createCall(){
        CallEntity callEntity = new CallEntity();
        callEntity.setAddress("Test");
        callEntity.setId(3);
        callEntity = callsRepository.save(callEntity);
        System.out.println(callEntity.getId());
        System.out.println(callEntity.getDateTime());
        assertEquals("Test",callEntity.getAddress());

    }




}
