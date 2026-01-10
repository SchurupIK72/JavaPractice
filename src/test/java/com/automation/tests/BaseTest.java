package com.automation.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;




public class BaseTest {
    @BeforeAll
    public static void setUp(){
    Configuration.browser = "chrome";
    Configuration.holdBrowserOpen = true;
    }
    @BeforeEach
    void openLoginPage() {
        Selenide.open("http://qa-stand-login.inzhenerka.tech/login");
    }
}

