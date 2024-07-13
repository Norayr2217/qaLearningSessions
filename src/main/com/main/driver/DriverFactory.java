package com.podcastle.e2e.main.java.driver;

import com.podcastle.e2e.main.java.configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
                WebDriverManager.chromedriver().setup();
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

    private final Supplier<WebDriver> chromeRemoteSupplier = () -> {
        if (driverThread.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            RemoteWebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL("http://" + Configuration.getHubHost() + ":4444/wd/hub"), options);
                driver.setFileDetector(new LocalFileDetector());
                driver.manage().window().maximize();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driverThread.set(driver);
        }
        return driverThread.get();
    };

    {
        MAP.put("chrome", chromeSupplier);
        MAP.put("remoteChrome", chromeRemoteSupplier);
    }

    public static DriverFactory get() {
        return new DriverFactory();
    }

    public WebDriver getDriver() {
        return MAP.get(Configuration.getBrowser()).get();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
