package main.com.test;

import main.com.main.driver.DriverFactory;
import main.com.main.utils.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class BrokenLinksTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver() {
        driver = DriverFactory.get().getDriver();
    }

    // https://the-internet.herokuapp.com/broken_images

    @Test
    public void linkTest() throws InterruptedException {
        driver.get("https://www.podcastle.ai");

        System.out.println("Before :: " + LocalDateTime.now());

        Thread.sleep(5000);

        driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("href"))
                .forEach(src -> System.out.println(LinkUtil.getResponseCode(src) + ": ::: " + src));

        System.out.println("After :: " + LocalDateTime.now());
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}