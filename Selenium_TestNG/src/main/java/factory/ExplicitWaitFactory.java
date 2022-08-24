package factory;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {
    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getEXPLICIT_WAIT_TIME()));
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        } return element;

    }
}
