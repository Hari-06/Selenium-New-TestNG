package com.page;

import driver.DriverManager;
import enums.WaitStrategy;
import factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends Exception {

    protected void click(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.click();
    }

    protected void sendKeys(By locator, String value, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.sendKeys(value);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
