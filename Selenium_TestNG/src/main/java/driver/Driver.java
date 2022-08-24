package driver;

import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factory.DriverFactory;
import utils.PropertyUtil;
import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(PropertyUtil.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
    }

}
