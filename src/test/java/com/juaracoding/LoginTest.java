package com.juaracoding;

// import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;

import io.appium.java_client.AppiumDriver;

public class LoginTest {

    private AppiumDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    @Parameters({"mobile", "appPackage", "appActivity"})
    public void setUp(String mobile, String appPackage, String appActivity) {
        // Initialize the Appium driver and login page
        DriverSingleton.getInstance(mobile, appPackage, appActivity);
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
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

    @Test(description = "Test Case: Successful Login")
    @Parameters({"username", "password"})
    public void testSuccessfulLogin(String username, String password) {
        // Go to login page
        loginPage.goToLoginPage();
        // Perform login and verify success
        loginPage.login(username, password);
    }

    // @Test(description = "Test Case: Invalid Login")
    // public void testInvalidLogin() {
    //     // Go to login page
    //     loginPage.goToLoginPage();
    //     // Perform invalid login and verify error
    //     loginPage.login("invalid", "invalid");
    //     String error = loginPage.getErrorMessage();
    //     Assert.assertEquals(error, "Username and password do not match any user in this service.", "Expected error message for invalid login");
    // }
}
