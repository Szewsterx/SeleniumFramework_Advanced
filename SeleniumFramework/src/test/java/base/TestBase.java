package base;

import configuration.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import providers.DriverProvider;

public abstract class TestBase {
    protected WebDriver driver;
    private Configuration configuration = ConfigFactory.create(Configuration.class);

    @BeforeMethod
    public void setUpBeforeEach() {
        driver = new DriverProvider().getDriver();
        driver.get(configuration.applicationAddress());
    }

    @AfterMethod
    public void cleanUpAfterEach() {
        driver.quit();
    }
}
