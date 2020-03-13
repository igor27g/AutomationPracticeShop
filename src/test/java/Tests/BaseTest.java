package Tests;

import Drivers.DriverManager;
import Drivers.DriverManagerFactory;
import Drivers.DriverType;
import Utils.ConfigurationReader;
import Utils.TestDataReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    DriverManager driverManager;

    protected ConfigurationReader configuration;
    protected TestDataReader testData;
    private String testDataLocation = "src/test/java/TestData.properties";
    private String configurationLocation = "src/configs/Configuration.properties";


    private void getConfiguration() {
        testData = new TestDataReader(testDataLocation);
        configuration = new ConfigurationReader(configurationLocation);
    }

    @BeforeAll
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        getConfiguration();
    }

    @BeforeEach
    public void testSetUp() {
        driver = driverManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        driverManager.quitDriver();
    }

}

