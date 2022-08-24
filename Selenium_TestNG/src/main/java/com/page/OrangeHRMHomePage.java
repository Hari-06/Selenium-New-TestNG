package com.page;

import com.google.common.util.concurrent.Uninterruptibles;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public final class OrangeHRMHomePage extends BasePage {

    private static final By linkWelcome = By.id("welcome");
    private static final By linkLogout = By.xpath("//a[text()= 'Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(linkWelcome, WaitStrategy.CLICKABLE);
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        click(linkLogout, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();
    }

}
