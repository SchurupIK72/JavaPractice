package com.automation.tests;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public abstract class BaseApiTest {
    protected static final String API_KEY = "API_KEY123";
        @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://qa-stand-login.inzhenerka.tech/api";
}
}
