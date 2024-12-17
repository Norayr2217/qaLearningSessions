package main.com.test.javaDesignPatterns.webDriverStrategy;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotWebDriver extends WebDriverDecorator {
    public ScreenshotWebDriver(CustomWebDriver decoratedDriver) {
        super(decoratedDriver);
    }

    @Override
    public void quit() {
        captureScreenshot();
        decoratedDriver.quit();
    }

    private void captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) ((SeleniumWebDriver) decoratedDriver).driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot has been captured - " + source);
    }
}


