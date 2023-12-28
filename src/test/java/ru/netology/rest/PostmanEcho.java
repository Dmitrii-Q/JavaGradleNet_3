package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEcho {
    @Test
    void POSTrequest() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Hallo") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия

                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Dmitrii"))
        ;
    }


}
