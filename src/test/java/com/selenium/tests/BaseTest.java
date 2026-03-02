package com.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.selenium.utils.DriverFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected String url;

    @BeforeMethod
    public void setup() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        url = properties.getProperty("url");

        DriverFactory.initDriver();
        DriverFactory.getDriver().get(url);
        System.out.print(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}