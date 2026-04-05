package com.juaracoding;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.ProductPage;

import io.appium.java_client.AppiumDriver;

public class ProductTest {

    private AppiumDriver driver;
    private ProductPage productPage;

    @BeforeClass
    @Parameters({"mobile", "appPackage", "appActivity", "username", "password"})
    public void setUp(String mobile, String appPackage, String appActivity, String username, String password) {
        // Initialize the Appium driver and pages
        DriverSingleton.getInstance(mobile, appPackage, appActivity);
        driver = DriverSingleton.getDriver();
        productPage = new ProductPage(driver);
    }

    @AfterClass
    public void tearDown() {
        // Close the Appium driver
        // Add a small wait to ensure all actions are completed before quitting
        try {
            Thread.sleep(1000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverSingleton.closeObjectInstance();
    }

    @Test(description = "Test Case: Sort Products by Price Low to High")
    public void testSortProductsLowToHigh() {
        // Sort products and verify
        productPage.sortByPriceLowToHigh();
        // Add assertion for sorted order
    }

    @Test(description = "Test Case: Sort Products by Price High to Low")
    public void testSortProductsHighToLow() {
        // Sort products and verify
        productPage.sortByPriceHighToLow();
    }

}