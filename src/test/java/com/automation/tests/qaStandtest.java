package com.automation.tests;
import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.SeleneseLocators.byText;
import static com.codeborne.selenide.Condition.visible;


public class qaStandtest {
        @Test
    void openLoginPage()  {
    Configuration.browser = "chrome";
    Selenide.open("http://qa-stand-login.inzhenerka.tech/login");

    $("#username").setValue("admin");
    $(By.name("password")).setValue("admin123");
    $("button[type='submit']").shouldHave(text("Войти"));
    $("button[type=submit]").click();
    $("a[href='/logout']").shouldHave(text("Выйти"));
    $("a[href='/logout']").click();

    }

    @Test
    void openLoginPageWithEmptyFields()  {
        Configuration.browser = "chrome";
        Selenide.open("http://qa-stand-login.inzhenerka.tech/login");
    $("button[type='submit']").shouldHave(text("Войти"));
    $("button[type='submit']").click();
    $("a[href='/logout']").click();

    }

        @Test
    void openLoginPage_2()  {
    Configuration.browser = "chrome";
    Selenide.open("http://qa-stand-login.inzhenerka.tech/login");
    $("#username").setValue("admin");
    $(By.name("password")).setValue("admin123");
    $(By.xpath("//*[text()='Войти']")).shouldBe(visible);
    $(By.xpath("//*[text()='Войти']")).shouldHave(text("Войти"));
    $(By.xpath("//*[text()='Войти']")).click();
    $(By.xpath("//*[text()='Выйти']")).shouldBe(visible);
    $(By.xpath("//*[text()='Выйти']")).shouldHave(text("Выйти"));
    $(By.xpath("//*[text()='Выйти']")).click();
    }
}
