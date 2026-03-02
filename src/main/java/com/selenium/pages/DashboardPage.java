package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.selenium.utils.DriverFactory;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By logoutBtn = By.cssSelector("a[href='/logout']");

    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(logoutBtn).isDisplayed();
    }
}