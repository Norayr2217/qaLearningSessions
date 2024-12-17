package main.com.test.javaDesignPatterns.webDriverStrategy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriver implements CustomWebDriver {
    WebDriver driver;

    public SeleniumWebDriver() {
        driver = new ChromeDriver();
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public void quit() {
        driver.quit();
    }
}

