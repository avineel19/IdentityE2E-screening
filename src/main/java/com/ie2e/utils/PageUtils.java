package com.ie2e.utils;

import com.ie2e.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ie2e.config.ConfigReader.getIntProperty;

public class PageUtils {

    public static WebElement getElementWithWaitTime(By locator) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getIntProperty("element.wait.max.in.sec")));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static boolean isElementPresent(By locator) {
        WebDriver webdriver = DriverManager.getDriver();
        try {
            WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(getIntProperty("element.wait.max.in.sec")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static void clickWhenReady(By locator, By postClickLocator) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getIntProperty("element.wait.max.in.sec")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        if (postClickLocator != null) {
            isElementPresent(postClickLocator);
        }
    }

}
