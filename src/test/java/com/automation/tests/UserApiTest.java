package com.automation.tests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UserApiTest extends BaseApiTest{

    private static final String TEST_USERNAME = "testuser";
    @Test
    void getAdmin(){
        given()
        .queryParam("API_KEY", "API_KEY123")
        .when()
        .get("users/admin")
        .then()
        .statusCode(200)
        .body("username", equalTo("admin"));
    }
    @Disabled
    @Test
    void createUser(){
               String requestBody = """
            {
              "admin": false,
              "age": 60,
              "description": "Лучший тестер в мире",
              "jobtitle": "Тестировщик",
              "name": "Автоматизатор Тестович",
              "password": "password123",
              "username": "%s"
            }
            """.formatted(TEST_USERNAME);

        given()
            .queryParam("API_KEY", API_KEY)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("username", equalTo(TEST_USERNAME));
    }
    @Disabled
    @Test
    void deleteUser(){
    }
}
