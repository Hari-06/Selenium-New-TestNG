package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    static void setDriver(WebDriver driver) {
        webDriverThreadLocal.set(driver);
    }

    static void unLoad()
    {
        webDriverThreadLocal.remove();
    }
}
