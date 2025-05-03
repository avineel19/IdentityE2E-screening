package com.ie2e.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.ie2e.config.ConfigReader.getIntProperty;

public class ChromeDriverManager implements WebDriverManager {
    public WebDriver getDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getIntProperty("implicit.wait.max.in.sec")));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(getIntProperty("page.load.wait.max.in.sec")));
        return driver;
    }
}
