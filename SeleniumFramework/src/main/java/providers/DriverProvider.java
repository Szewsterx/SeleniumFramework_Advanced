package providers;

import models.DriverType;
import configuration.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {

    public WebDriver getDriver() {
        switch (getDriverType()) {
            case IE:
                //TODO add support for internet explorer
                throw new UnsupportedOperationException();
            case EDGE:
                //TODO add support for edge
                throw new UnsupportedOperationException();
            case FIREFOX:
                //TODO add support for firefox
                throw new UnsupportedOperationException();
            case CHROME:
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                return new ChromeDriver(chromeOptions);
        }
    }

    private DriverType getDriverType() {
        Configuration configuration = ConfigFactory.create(Configuration.class);
        DriverType driverType;
        String browserName = configuration.browserName().toUpperCase();
        try {
            driverType = DriverType.valueOf(browserName);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Unsupported browserName " + browserName);
        }
        return driverType;
    }
}
