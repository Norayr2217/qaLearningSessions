package main.com.test.javaDesignPatterns.webDriverStrategy;

import org.openqa.selenium.By;

public class WebDriverStrategyDesignPatternMain {
        public static void main(String[] args) {
        CustomWebDriver webDriver = new SeleniumWebDriver();

        webDriver = new ScreenshotWebDriver(webDriver);

        webDriver = new LoggingWebDriver(webDriver);

        webDriver.get("https://www.example.com");
        System.out.println("Title - " + webDriver.getTitle());

        webDriver.findElement(By.tagName("h1"));

        webDriver.quit();
    }
}
