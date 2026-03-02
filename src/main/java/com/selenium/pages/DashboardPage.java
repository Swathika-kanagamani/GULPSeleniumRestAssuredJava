package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import com.selenium.utils.DriverFactory;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By logoutBtn = By.cssSelector("a[href='/logout']");


    public boolean isLogoutButtonDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/logout']")));
            return driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}