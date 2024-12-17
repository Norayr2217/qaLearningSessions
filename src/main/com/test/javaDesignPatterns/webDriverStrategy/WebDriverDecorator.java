package main.com.test.javaDesignPatterns.webDriverStrategy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class WebDriverDecorator implements CustomWebDriver {
    protected CustomWebDriver decoratedDriver;

    public WebDriverDecorator(CustomWebDriver decoratedDriver) {
        this.decoratedDriver = decoratedDriver;
    }

    @Override
    public void get(String url) {
        decoratedDriver.get(url);
    }

    @Override
    public String getTitle() {
        return decoratedDriver.getTitle();
    }

    @Override
    public WebElement findElement(By by) {
        return decoratedDriver.findElement(by);
    }

    @Override
    public void quit() {
        decoratedDriver.quit();
    }
}

