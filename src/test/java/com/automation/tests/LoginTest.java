package com.automation.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest{
    
    private LoginPage loginPage;
    
    @BeforeEach
    void initPage() {
        loginPage = new LoginPage();
    } 

    @Test
    public void runLoginTests() {
        loginPage.setUsername("admin");
        loginPage.setPassword("admin123");
        loginPage.login();
        loginPage.logout();
    }
    @Test
    public void runLoginTestUser() {
        loginPage.setUsername("user");
        loginPage.setPassword("user123");
        loginPage.login();
        loginPage.shouldSeeGreeting("user");
    }
    
    @ParameterizedTest
    @CsvSource(value = {
    "admin, admin123",
    "user, user123", 
    " , "} ,ignoreLeadingAndTrailingWhitespace = true)
        public void runLoginTestUserCsv(String username, String password) {
            loginPage.setUsername(username);
            loginPage.setPassword(password);
            loginPage.login();
            //loginPageUserParam.shouldSeeGreeting(username);
            loginPage.logout();
            loginPage.shouldBeOnLoginPage();
        }

        @Test
        public void neggativeLoginTest(){
            loginPage.setUsername("123");
            loginPage.setPassword("123");
            loginPage.login();
            loginPage.shouldSeeLoginError();
        }
}
