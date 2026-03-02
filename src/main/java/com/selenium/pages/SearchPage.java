package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.selenium.utils.DriverFactory;

public class SearchPage {

    private WebDriver driver;

    public SearchPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By searchBox = By.xpath("//input[@placeholder='Search']");
    private By result = By.xpath("//span[text()='Admin']");

    public void search(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public boolean isResultDisplayed() {
        return driver.findElement(result).isDisplayed();
    }
}