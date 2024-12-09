package main.com.test.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import main.com.test.appium.pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log In \"]")
    private WebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Log in\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email or password is incorrect.\"]")
    private WebElement errorMessage;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plan your first recording\"]")
    private WebElement homePageHeader;

    public LoginPage() {
        super();
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void enterEmail(String email) {
        actions.moveToElement(emailField).click().perform();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        actions.moveToElement(passwordField).click().perform();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    public boolean isHomePageOpened() {
        wait.until(ExpectedConditions.visibilityOf(homePageHeader));
        return homePageHeader.isDisplayed();
    }

    public void login(String email, String password) {
        clickLoginButton();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
