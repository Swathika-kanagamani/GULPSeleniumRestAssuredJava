package com.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.selenium.utils.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}