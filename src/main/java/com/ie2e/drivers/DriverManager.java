package com.ie2e.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }
    public static WebDriver getDriver() {
        return threadLocal.get();
    }
    public static void quitDriver() {
        threadLocal.get().quit();
    }
}
