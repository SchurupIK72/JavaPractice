package com.automation.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;




public class BaseTest {
    @BeforeAll
    public static void setUp(){
    Configuration.browser = "chrome";
    Configuration.headless = true; 
    Configuration.timeout = 10000;
    //Configuration.holdBrowserOpen = true;
    }
    @BeforeEach
    void openLoginPage() {
        Selenide.open("http://qa-stand-login.inzhenerka.tech/login");
    }
    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

