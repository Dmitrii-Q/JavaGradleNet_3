package ru.netology.rest;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class MobileBankApiTestV4 {
    @Test
    void shouldReturnDemoAccounts() {
      // Given - When - Then
      // Предусловия
        ValidatableResponse body = given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                .header("Content-Type", "application/json; charset=UTF-8")
                .body("", hasSize(3))
                .body("[0].id",equalTo(1))
                .body("[0].name",equalTo("Текущий счёт"))
                .body("[0].balance",equalTo(992821429))
                .body("[0].number",equalTo("•• 0668"))
                .body("[0].currency",equalTo("RUR"))
                .body("[1].currency",equalTo("USD"))

        ;
    }
}
