package com.juaracoding.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement scrollToElementById(String id) {
        return driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().resourceId(\"" + id + "\"));"));
    }

    public WebElement scrollToElementByText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))"
            + ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"));"));
    }
}