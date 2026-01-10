package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object для главной страницы Google
 */
public class GoogleMainPage extends BasePage {
    // Локаторы элементов
    private static final By SEARCH_FIELD = By.name("q");
    private static final By SEARCH_BUTTON = By.name("btnK");

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выполнить поиск
     */
    public void search(String query) {
        logger.info("Выполнение поиска: " + query);
        navigateTo("https://www.google.com");
        enterText(SEARCH_FIELD, query);
        clickElement(SEARCH_BUTTON);
    }

    /**
     * Получить текст поля поиска
     */
    public String getSearchFieldText() {
        return driver.findElement(SEARCH_FIELD).getAttribute("value");
    }
}
