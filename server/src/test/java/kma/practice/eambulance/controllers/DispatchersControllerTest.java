package kma.practice.eambulance.controllers;

import io.restassured.RestAssured;
import kma.practice.eambulance.dto.DispatcherDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class DispatchersControllerTest {

    @LocalServerPort
    void savePort(final int port) {
        // save port of locally starter server during test
        RestAssured.port = port;
    }

    @Test
    void shouldSendSaveRequest() {

        DispatcherDto response = given()
                .body(DispatchersControllerTest.class.getResourceAsStream("/saveDispatcher.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/dispatchers")
                .then()

                .extract()
                .as(DispatcherDto.class);


        DispatcherDto dispatcherDto = new DispatcherDto();
        dispatcherDto.setTabNumber(123456777);
        dispatcherDto.setFullName("Kurash Inna");

        assertThat(response).isEqualTo(dispatcherDto);
    }

    @Test
    void shouldSendUpdateRequest() {

        DispatcherDto response = given()
                .body(DispatchersControllerTest.class.getResourceAsStream("/saveDispatcher.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put("/dispatchers")
                .then()

                .extract()
                .as(DispatcherDto.class);

        DispatcherDto dispatcherDto = new DispatcherDto();
        dispatcherDto.setTabNumber(123456777);
        dispatcherDto.setFullName("Kurash Inna");

        assertThat(response).isEqualTo(dispatcherDto);
    }

    @Test
    void shouldSendGetAllRequest() {

        given().body(DispatchersControllerTest.class.getResourceAsStream("/saveDispatcher.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/dispatchers");

        DispatcherDto[] response = given()
                .when()
                .get("/dispatchers/all")
                .then()
                .extract()
                .as(DispatcherDto[].class);

        assertThat(response.length).isGreaterThan(0);
    }

    @Test
    void shouldSendGetRequest() {

        DispatcherDto responseSave = given()
                .body(DispatchersControllerTest.class.getResourceAsStream("/saveDispatcher.json"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put("/dispatchers")
                .then()

                .extract()
                .as(DispatcherDto.class);

        DispatcherDto responseGet = given()
                .when()
                .get("/dispatchers/123456777")
                .then()
                .extract()
                .as(DispatcherDto.class);
        assertThat(responseGet).isEqualTo(responseSave);
    }
}
