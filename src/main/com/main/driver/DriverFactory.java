package main.com.main.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
    public WebDriver driver;
    private final Supplier<WebDriver> chromeSupplier = () -> {
        synchronized (driverThread) {
            if (driverThread.get() == null) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                chromeOptions.setExperimentalOption("prefs", Collections.singletonMap("autofill.credit_card_enabled", false));
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);
                driverThread.set(driver);

            }
            return driverThread.get();
        }
    };

    public static DriverFactory get() {
        return new DriverFactory();
    }

    public WebDriver getDriver() {
        return chromeSupplier.get();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
