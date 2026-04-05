package com.juaracoding.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    @iOSXCUITBy(accessibility = "username")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    @iOSXCUITBy(accessibility = "password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    @iOSXCUITBy(accessibility = "loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/errorMessage")
    @iOSXCUITBy(accessibility = "errorMessage")
    private WebElement errorMessage;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    @iOSXCUITBy(accessibility = "menuIV")
    private WebElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Login Menu Item\"]")
    @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login Menu Item\"]")
    private WebElement loginMenuItem;

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void goToLoginPage() {
        menuButton.click();
        loginMenuItem.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
