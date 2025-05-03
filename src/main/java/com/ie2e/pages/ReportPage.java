package com.ie2e.pages;

import com.ie2e.data.ByLocators;
import com.ie2e.data.parse.CarDetails;
import com.ie2e.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ie2e.utils.PageUtils.getElementWithWaitTime;
import static com.ie2e.utils.PageUtils.isElementPresent;

public class ReportPage {
    private static final Logger logger = LoggerFactory.getLogger(ReportPage.class);
    public WebDriver driver;
    public ReportPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public CarDetails getCarDetails(String carRegNumber) {
        if(isElementPresent(By.xpath(ByLocators.MAKE_XPATH))) {
            CarDetails carDetails = new CarDetails();
            carDetails.setCarRegNo(carRegNumber);
            WebElement model = getElementWithWaitTime(By.xpath(ByLocators.CAR_MODEL_XPATH));
            carDetails.setCarModel(model.getText());
            WebElement make = getElementWithWaitTime(By.xpath(ByLocators.MAKE_XPATH));
            carDetails.setCarMake(make.getText());
            WebElement yearOfManufacture = getElementWithWaitTime(By.xpath(ByLocators.CAR_YEAR_MANUFACTURE_XPATH));
            carDetails.setYearOfManufacture(yearOfManufacture.getText());
            logger.info("Car details is: " + carDetails);
            return carDetails;
        } else {
            return null;
        }
    }


}
