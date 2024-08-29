package test.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import test.appium.common.AppiumServerManager;
import test.appium.common.DriverManager;
import java.time.Duration;

public class IOSCalculatorTest {

    private IOSDriver driver;

    private AppiumServerManager serverManager;

    @BeforeTest
    public void startAppium() {
        serverManager = new AppiumServerManager();
        serverManager.startServer();
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.get().getDriver();
    }

    @Test
    public void testAddition() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the calculator to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("2")));

        // Perform 2 + 3 = 5
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("add")).click();
        driver.findElement(AppiumBy.accessibilityId("3")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        // Get the result
        WebElement resultElement = driver.findElement(AppiumBy.accessibilityId("Result"));
        String result = resultElement.getText();

        // Verify the result
        Assert.assertEquals(result, "5", "The addition result is incorrect");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.get().quitDriver(driver);
    }

    @AfterTest
    public void stopAppium() {
        serverManager.stopServer();
    }
}