package main.com.test.javaDesignPatterns.webDriverStrategy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoggingWebDriver extends WebDriverDecorator {
    public LoggingWebDriver(CustomWebDriver decoratedDriver) {
        super(decoratedDriver);
    }

    @Override
    public void get(String url) {
        System.out.println("Navigate to - " + url);
        decoratedDriver.get(url);
    }

    @Override
    public WebElement findElement(By by) {
        System.out.println("Find element - " + by);
        return decoratedDriver.findElement(by);
    }
}

