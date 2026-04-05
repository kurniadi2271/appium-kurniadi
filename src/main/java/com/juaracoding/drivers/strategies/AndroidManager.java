package com.juaracoding.drivers.strategies;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidManager implements DriverStrategy {

    private String appPackage;
    private String appActivity;

    public AndroidManager() {
        this.appPackage = "com.saucelabs.mydemoapp.android";
        this.appActivity = "com.saucelabs.mydemoapp.android.view.activities.SplashActivity";
    }

    public AndroidManager(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    @Override
    public AppiumDriver setStrategy() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 3 API 29");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("10.0");
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setNoReset(true);

        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalStateException("Appium server URL is invalid", e);
        }   
        return driver;
    }

}
