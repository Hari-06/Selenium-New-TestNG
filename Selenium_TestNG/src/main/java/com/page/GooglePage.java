package com.page;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class GooglePage extends BasePage {

    private final By textboxSearch = By.name("q");
    private final By buttonSearch = By.xpath("(//input[@value='Google Search'])[2]");

    public String getTitle() {
        return getPageTitle();
    }

    public GooglePage enterSearchText(String searchText) {
        sendKeys(textboxSearch,searchText, WaitStrategy.PRESENCE);
        return this;
    }
    public GooglePage clickSearch() {
        click(buttonSearch,WaitStrategy.PRESENCE);
        return this;
    }


}
