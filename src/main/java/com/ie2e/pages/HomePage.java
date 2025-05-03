package com.ie2e.pages;

import com.ie2e.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.sql.Driver;

import static com.ie2e.config.ConfigReader.getProperty;
import static com.ie2e.data.ByLocators.MAKE_XPATH;
import static com.ie2e.utils.PageUtils.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    @FindBy(id = "subForm1")
    private WebElement carRegNumInputTextBox;

    @FindBy(className = "check-now-button")
    private WebElement valueYourCarBtn;

    WebDriver driver;

    public HomePage() {
        driver = DriverManager.getDriver();

    }

    private void enterCarRegNum(String carRegNum) {
        getElementWithWaitTime(By.id("subForm1")).sendKeys(carRegNum);
    }

    private ReportPage clickYourCarBtn() {
        isElementPresent(By.className("check-now-button"));
        clickWhenReady(By.className("check-now-button"),By.xpath(MAKE_XPATH));
        return new ReportPage();
    }

    public ReportPage enterCarNumGetReport(String carNum) {
        enterCarRegNum(carNum);
        return clickYourCarBtn();
    }
}
