package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium.pages.LoginPage;
import com.selenium.pages.DashboardPage;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("tomsmith", "SuperSecretPassword!");

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
