package main.com.test.javaDesignPatterns.webDriverStrategy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface CustomWebDriver {
    void get(String url);
    String getTitle();
    WebElement findElement(By by);
    void quit();
}

