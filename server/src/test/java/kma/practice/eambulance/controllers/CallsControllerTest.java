package kma.practice.eambulance.controllers;

import kma.practice.eambulance.database.entities.CallStatus;
import kma.practice.eambulance.dto.CallDto;
import kma.practice.eambulance.dto.CrewDto;
import kma.practice.eambulance.dto.DispatcherDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import io.restassured.RestAssured;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CallsControllerTest {

    @LocalServerPort
    void savePort(final int port) {
        // save port of locally starter server during test
        RestAssured.port = port;
    }

    @Test
    void shouldSendSaveRequest() {
        CallDto response = given()
                .body(CallsControllerTest.class.getResourceAsStream("/saveCall.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/calls")
                .then()

                .extract()
                .as(CallDto.class);

        DispatcherDto dispatcherDto = new DispatcherDto();
        dispatcherDto.setTabNumber(123456789);

        CrewDto crewDto = new CrewDto();
        crewDto.setTabNumber(123456798);

        CallDto callDto = new CallDto(3,LocalDateTime.parse("2021-06-17 15:45:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Nezalezhnosti str. 25, flat 16", "Heart attack", "063 245 98 54",
                "unstable",CallStatus.WAITING_FOR_CREW,"none",crewDto,dispatcherDto);

        assertThat(response).isEqualTo(callDto);
    }

    @Test
    void shouldSendUpdateRequest() {

        CallDto response = given()
                .body(CallsControllerTest.class.getResourceAsStream("/saveCall.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put("/calls")
                .then()

                .extract()
                .as(CallDto.class);

        DispatcherDto dispatcherDto = new DispatcherDto();
        dispatcherDto.setTabNumber(123456789);

        CrewDto crewDto = new CrewDto();
        crewDto.setTabNumber(123456798);

        CallDto callDto = new CallDto(3,LocalDateTime.parse("2021-06-17 15:45:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Nezalezhnosti str. 25, flat 16", "Heart attack", "063 245 98 54",
                "unstable",CallStatus.WAITING_FOR_CREW,"none",crewDto,dispatcherDto);

        assertThat(response).isEqualTo(callDto);
    }

    @Test
    void shouldSendGetAllRequest() {

        given().body(CallsControllerTest.class.getResourceAsStream("/saveCall.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/calls");

        CallDto[] response = given()
                .when()
                .get("/calls/all")
                .then()
                .extract()
                .as(CallDto[].class);

        assertThat(response.length).isGreaterThan(0);
    }

    @Test
    void shouldSendGetRequest() {

        CallDto responseSave = given()
                .body(CallsControllerTest.class.getResourceAsStream("/saveCall.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/calls")
                .then()

                .extract()
                .as(CallDto.class);

        CallDto responseGet = given()
                .when()
                .get("/calls/"+responseSave.getId())
                .then()
                .extract()
                .as(CallDto.class);
        assertThat(responseGet).isEqualTo(responseSave);
    }
}