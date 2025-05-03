package com.ie2e.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.ie2e.config.ConfigReader.getProperty;

public class WebDriverFactory {
    private static WebDriver driver;
    public static WebDriver getWebDriver() {
        switch (getProperty("browser.name")) {
            case "chrome" -> driver = createWebDriver(new ChromeDriverManager());
            default -> throw new IllegalArgumentException("Unsupported browser");
        };
        return driver;
    }

    private static WebDriver createWebDriver(WebDriverManager driverManager) {
        return driverManager.getDriver();
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
