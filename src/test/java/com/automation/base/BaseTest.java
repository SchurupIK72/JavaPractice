package com.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class для всех тестов - управление WebDriver
 */
public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    /**
     * Инициализация Chrome драйвера с профилем пользователя
     */
    protected void initChromeDriver() {
        logger.info("Инициализация Chrome драйвера...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Используем отдельный профиль для тестирования
        String testProfileDir = System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data\\TestProfile";
        options.addArguments(
            "user-data-dir=" + testProfileDir,
            "--no-first-run",
            "--no-default-browser-check",
            "--disable-blink-features=AutomationControlled",
            "--disable-dev-shm-usage",
            "--disable-gpu"
        );
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * Инициализация Firefox драйвера
     */
    protected void initFirefoxDriver() {
        logger.info("Инициализация Firefox драйвера...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    /**
     * Закрытие браузера
     */
    protected void closeBrowser() {
        if (driver != null) {
            logger.info("Закрытие браузера...");
            driver.quit();
        }
    }

    /**
     * Получить текущий URL
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Получить заголовок страницы
     */
    protected String getPageTitle() {
        return driver.getTitle();
    }
}
