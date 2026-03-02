package com.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.selenium.utils.DriverFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected String url;
    protected Properties properties;

    /**
     * Loads configuration from the file specified by the system property
     * `configFile`. If the property is not provided, the default
     * `config.properties` in the working directory is used.
     *
     * You can run Maven like:
     * mvn test -DconfigFile=path/to/config.properties
     */
    @BeforeMethod
    public void setup() throws Exception {
        properties = new Properties();
        String configPath = System.getProperty("configFile", "config.properties");
        properties.load(new FileInputStream(configPath));

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