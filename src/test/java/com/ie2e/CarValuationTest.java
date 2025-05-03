package com.ie2e;

import com.ie2e.data.parse.CarDetails;
import com.ie2e.drivers.DriverManager;
import com.ie2e.drivers.WebDriverFactory;
import com.ie2e.pages.HomePage;
import com.ie2e.pages.ReportPage;
import com.ie2e.utils.ExtractCarReg;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

import static com.ie2e.config.ConfigReader.getProperty;
import static com.ie2e.utils.ReadCarOutputFile.readCarOutputFile;

public class CarValuationTest {
    private static final Logger logger = LoggerFactory.getLogger(CarValuationTest.class);
    private WebDriver driver;
    static List<CarDetails> expectedDetails;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getWebDriver();
        DriverManager.setDriver(driver);
        driver.get(getProperty("base.url"));
    }
    static Set<String> getCarRegs() throws IOException {
        expectedDetails = readCarOutputFile();
        return ExtractCarReg.extractCarReg(getProperty("input.file"));
    }

    @ParameterizedTest
    @MethodSource("getCarRegs")
    public void CarValuationTestCase(String carReg) {
        HomePage homePage = new HomePage();
        carReg = carReg.replaceAll(" ", "");
        ReportPage reportPage = homePage.enterCarNumGetReport(carReg);
        CarDetails carDetails = reportPage.getCarDetails(carReg);
        Assertions.assertNotNull(carDetails,"Unable to find CarDetails for Reg " + carReg);
        //Validate - Data matches to OutPutFile
        CarDetails expectedDetails = extractMatchingCarDetails(carReg);
        logger.info("Car Actual Details: {}", carDetails.toString());
        logger.info("Car Expected Details: {}", expectedDetails.toString());
        Assertions.assertEquals(expectedDetails, carDetails,
                "Unable to match Car Details in expected output file for Reg " + carReg);
    }

    private CarDetails extractMatchingCarDetails(String carReg) {
        return expectedDetails.stream().filter(d-> StringUtils.endsWithIgnoreCase(d.getCarRegNo(), carReg))
                .findFirst().orElse(null);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
