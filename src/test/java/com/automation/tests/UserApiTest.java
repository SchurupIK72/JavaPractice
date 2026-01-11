package com.automation.tests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserApiTest extends BaseApiTest{

    private static final String TEST_USERNAME = "testusers0";
    @Test
    void getAdmin(){
        given()
        .queryParam("API_KEY", API_KEY)
        .when()
        .get("users/admin")
        .then()
        .statusCode(200)
        .body("username", equalTo("admin"));
    }
    @Order(1)
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
            .statusCode(201);
            //.body("username", equalTo(TEST_USERNAME));
    }
     @Order(2)
     @Test
    void getCreatedUser(){
        given()
        .queryParam("API_KEY", API_KEY)
        .when()
        .get("users/" + TEST_USERNAME)
        .then()
        .statusCode(200)
        .body("username", equalTo(TEST_USERNAME));
    }
    @Order(3)
    @Test
    void changeCreatedUser(){
                String requestBody = """
            {
              "admin": false,
              "age": 60,
              "description": "Лучший тестер в мире",
              "jobtitle": "Тестировщик",
              "name": "Автоматизатор Тестовиччч",
              "password": "password1234",
              "username": "%s"
            }
            """.formatted(TEST_USERNAME);
        given()
            .queryParam("API_KEY", API_KEY)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/users/" + TEST_USERNAME)
        .then()
            .statusCode(200);
    }

    @Order(4)
    @Test
    void deleteUser(){
        given()
        .queryParam("API_KEY", API_KEY)
    .when()
        .delete("/users/{username}", TEST_USERNAME)
    .then()
        .statusCode(anyOf(is(200), is(204)));

    }


}
