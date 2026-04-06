package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;

import io.appium.java_client.AppiumDriver;

public class CartTest {

    private AppiumDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeClass
    @Parameters({"mobile", "appPackage", "appActivity"})
    public void setUp(String mobile, String appPackage, String appActivity) {
        // Initialize the Appium driver and pages
        DriverSingleton.getInstance(mobile, appPackage, appActivity);
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass
    public void tearDown() {
        // Close the Appium driver
        try {
            Thread.sleep(1000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverSingleton.closeObjectInstance();
    }

    @Test(description = "Test Case: Checkout Process")
    @Parameters({"mobile", "appPackage", "appActivity", "username", "password", "name", "address", "address2", "city", "state", "zip", "country", "cardNumber", "expiration", "securityCode"})
    public void testCheckout(String mobile, String appPackage, String appActivity, String username, String password, String name, String address, String address2, String city, String state, String zip, String country, String cardNumber, String expiration, String securityCode) {
        // Go to login page and login
        loginPage.goToLoginPage();
        loginPage.login(username, password);
        // Add product to cart
        productPage.selectFirstProduct();
        productPage.scrollToAddToCartButton();
        productPage.addProductToCart();
        // Go to cart
        productPage.goToCart();
        // Perform checkout
        productPage.addProductToCart();

        // cartPage.clickCheckout();
        cartPage.enterShippingInfo(name, address, address2, city, state, zip, country);
        cartPage.enterPaymentInfo(name, cardNumber, expiration, securityCode);
        cartPage.placeOrder();
        cartPage.completeCheckout();
        // Verify checkout complete
    }
}