package factory;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private DriverFactory(){
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver = null;

        String runMode = PropertyUtil.get(ConfigProperties.RUN_MODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL(PropertyUtil.get(ConfigProperties.SELENIUM_GRID_URL)), cap);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {

            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL(PropertyUtil.get(ConfigProperties.SELENIUM_GRID_URL)), cap);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}
