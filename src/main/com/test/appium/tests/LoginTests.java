package test.appium.tests;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.*;
import test.appium.common.DriverManager;
import test.appium.pages.LoginPage;
import test.appium.common.AppiumServerManager;

public class LoginTests {

    private IOSDriver driver;

    private AppiumServerManager serverManager;
    LoginPage loginPage;

    @BeforeTest
    public void startAppium() {
        serverManager = new AppiumServerManager();
        serverManager.startServer();
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.get().getDriver();
        loginPage = new LoginPage();
    }

    @Test
    public void invalidEmailPasswordValidation() {
        loginPage.login("invalid@podcastle.ai", "Admin123!");

        assert loginPage.isErrorMessageDisplayed() : "Error message not displayed";
    }

    @Test
    public void validCredentialsLoginValidation() {
        loginPage.login("lavtxauaccount@harakirimail.com", "qwerty");

        assert loginPage.isHomePageOpened() : "Login was not happened";
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