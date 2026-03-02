package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.pages.LoginPage;
import com.selenium.pages.DashboardPage;

public class LoginTests extends BaseTest {

    private String password;

    @BeforeMethod
    public void loadPassword() {
        // use properties loaded by BaseTest
        password = properties.getProperty("password");
    }

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("tomsmith", password);

        DashboardPage dashboard = new DashboardPage();

        Assert.assertTrue(
                dashboard.isLogoutButtonDisplayed(),
                "Valid login failed!");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("invalid"),
                "Error message not displayed!");
    }
}
