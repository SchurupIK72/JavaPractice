package com.automation.tests;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import org.junit.jupiter.api.BeforeEach;
//import static com.codeborne.selenide.Selenide.open; 
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.*;


public class LoginPage {
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField =$("[name='password']");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement logoutButton = $("a[href='/logout']");
    private final SelenideElement greeting = $("h2");

public void openLoginPage(){
    String URL = "http://qa-stand-login.inzhenerka.tech/login";
    Selenide.open(URL);
}
public void setUsername(String username){
    usernameField.setValue(username);
}
public void setPassword(String password){
    passwordField.setValue(password);
}
public void login(){
    loginButton.click();
}
public void logout(){
    logoutButton.click();
}

public void shouldSeeGreeting(String username) {
    greeting.shouldHave(text("Привет, " + username));
}

public void shouldSeeLoginError() {
    greeting.shouldHave(text("Вход не выполнен"));
}
public void shouldBeOnLoginPage(){
    usernameField.shouldBe(visible);
    passwordField.shouldBe(visible);
}

}

