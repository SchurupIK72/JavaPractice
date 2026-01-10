package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Page Object Model - базовый класс для всех страниц
 */
public class BasePage {
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * Ожидание видимости элемента и клик по нему
     */
    public void clickElement(By locator) {
        logger.debug("Клик по элементу: " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Ввод текста в поле
     */
    public void enterText(By locator, String text) {
        logger.debug("Ввод текста '" + text + "' в поле: " + locator);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Получить текст элемента
     */
    public String getText(By locator) {
        logger.debug("Получение текста из элемента: " + locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    /**
     * Проверить видимость элемента
     */
    public boolean isElementVisible(By locator) {
        try {
            logger.debug("Проверка видимости элемента: " + locator);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            logger.debug("Элемент не виден: " + locator);
            return false;
        }
    }

    /**
     * Перейти на страницу
     */
    public void navigateTo(String url) {
        logger.info("Переход на URL: " + url);
        driver.navigate().to(url);
    }
}
