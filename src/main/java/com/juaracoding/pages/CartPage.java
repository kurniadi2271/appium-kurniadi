package com.juaracoding.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public class CartPage extends BasePage {

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    @iOSXCUITBy(accessibility = "fullNameET")
    private WebElement fullNameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    @iOSXCUITBy(accessibility = "address1ET")
    private WebElement addressField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address2ET")
    @iOSXCUITBy(accessibility = "address2ET")
    private WebElement address2Field;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    @iOSXCUITBy(accessibility = "cityET")
    private WebElement cityField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/stateET")
    @iOSXCUITBy(accessibility = "stateET")
    private WebElement stateField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    @iOSXCUITBy(accessibility = "zipET")
    private WebElement zipField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    @iOSXCUITBy(accessibility = "countryET")
    private WebElement countryField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    @iOSXCUITBy(accessibility = "paymentBtn")
    private WebElement toPaymentButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    @iOSXCUITBy(accessibility = "cardNumberET")
    private WebElement cardNumberField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    @iOSXCUITBy(accessibility = "expirationDateET")
    private WebElement expirationDateField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    @iOSXCUITBy(accessibility = "securityCodeET")
    private WebElement securityCodeField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    @iOSXCUITBy(accessibility = "nameET")
    private WebElement paymentFullNameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/placeOrderBtn")
    @iOSXCUITBy(accessibility = "placeOrderBtn")
    private WebElement placeOrderButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/shoopingBt")
    @iOSXCUITBy(accessibility = "shoopingBt")
    private WebElement completeButton;


    public void enterShippingInfo(String name, String address, String address2, String city, String state, String zip, String country) {
        fullNameField.clear();
        fullNameField.sendKeys(name);
        addressField.clear();
        addressField.sendKeys(address);
        address2Field.clear();
        address2Field.sendKeys(address2);
        cityField.clear();
        cityField.sendKeys(city);
        stateField.clear();
        stateField.sendKeys(state);
        zipField.clear();
        zipField.sendKeys(zip);
        countryField.clear();
        countryField.sendKeys(country);
        scrollToElementById("com.saucelabs.mydemoapp.android:id/paymentBtn");
        click(toPaymentButton);
    }

    public void enterPaymentInfo(String paymentName, String cardNumber, String expiration, String securityCode) {
        paymentFullNameField.clear();
        paymentFullNameField.sendKeys(paymentName);
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
        expirationDateField.clear();
        expirationDateField.sendKeys(expiration);
        securityCodeField.clear();
        securityCodeField.sendKeys(securityCode);
        click(toPaymentButton);
    }

    public void placeOrder() {
        click(toPaymentButton); // Pastikan ID ini benar untuk Place Order
    }

    public void completeCheckout() {
        click(completeButton);
    }

}