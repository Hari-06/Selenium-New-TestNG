package com.page;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    private static final By textboxUsername = By.id("txtUsername");
    private static final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private static final By buttonLogin     = By.id("btnLogin");

    public OrangeHRMLoginPage enterUserName(String username) {
        sendKeys(textboxUsername,username, WaitStrategy.PRESENCE);
        return this;
    }
    public OrangeHRMLoginPage enterPassword (String password) {
        sendKeys(textboxPassword,password,WaitStrategy.PRESENCE);
        return this;
    }
    public OrangeHRMHomePage clickLogin() {
        click(buttonLogin,WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }
    public String getTitle() {
        return getPageTitle();
    }
}
