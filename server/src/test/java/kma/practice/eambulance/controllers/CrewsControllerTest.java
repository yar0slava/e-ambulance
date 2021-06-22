package kma.practice.eambulance.controllers;

import io.restassured.RestAssured;
import kma.practice.eambulance.database.entities.Availability;
import kma.practice.eambulance.dto.CrewDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CrewsControllerTest {

    @LocalServerPort
    void savePort(final int port) {
        // save port of locally starter server during test
        RestAssured.port = port;
    }

    @Test
    void shouldSendSaveRequest() {

        CrewDto response = given()
                .body(CrewsControllerTest.class.getResourceAsStream("/saveCrew.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/crews")
                .then()

                .extract()
                .as(CrewDto.class);


        CrewDto crewDto = new CrewDto();
        crewDto.setTabNumber(123456788);
        crewDto.setMembers("Balayev Ivan, Lepel Mykola, Boyko Oleksandra");
        crewDto.setCarNumber("СВ 9496 НМ");
        crewDto.setLocation("Danchenka str. 18, flat 55");
        crewDto.setAvailability(Availability.AVAILABLE);

        assertThat(response).isEqualTo(crewDto);
    }

    @Test
    void shouldSendUpdateRequest() {

        CrewDto response = given()
                .body(CrewsControllerTest.class.getResourceAsStream("/saveCrew.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put("/crews")
                .then()

                .extract()
                .as(CrewDto.class);

        CrewDto crewDto = new CrewDto();
        crewDto.setTabNumber(123456788);
        crewDto.setMembers("Balayev Ivan, Lepel Mykola, Boyko Oleksandra");
        crewDto.setCarNumber("СВ 9496 НМ");
        crewDto.setLocation("Danchenka str. 18, flat 55");
        crewDto.setAvailability(Availability.AVAILABLE);

        assertThat(response).isEqualTo(crewDto);
    }

    @Test
    void shouldSendGetAllRequest() {

        given().body(CrewsControllerTest.class.getResourceAsStream("/saveCrew.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/crews");

        CrewDto[] response = given()
                .when()
                .get("/crews/all")
                .then()
                .extract()
                .as(CrewDto[].class);

        assertThat(response.length).isGreaterThan(0);
    }

    @Test
    void shouldSendGetRequest() {

        CrewDto responseSave = given()
                .body(CrewsControllerTest.class.getResourceAsStream("/saveCrew.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/crews")
                .then()

                .extract()
                .as(CrewDto.class);

        CrewDto responseGet = given()
                .when()
                .get("/crews/123456788")
                .then()
                .extract()
                .as(CrewDto.class);
        assertThat(responseGet).isEqualTo(responseSave);
    }
}
