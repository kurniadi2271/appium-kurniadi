package com.juaracoding.drivers;

import java.time.Duration;

import com.juaracoding.drivers.strategies.DriverStrategy;
import com.juaracoding.drivers.strategies.DriverStrategyImplementer;

import io.appium.java_client.AppiumDriver;

public class DriverSingleton {

    private static DriverSingleton instance;
    private static AppiumDriver driver;
    private static String appPackage;
    private static String appActivity;

    private DriverSingleton(String driverStrategy) {
        instantiate(driverStrategy);
    }

    private DriverSingleton(String driverStrategy, String appPkg, String appAct) {
        appPackage = appPkg;
        appActivity = appAct;
        instantiate(driverStrategy);
    }

    public AppiumDriver instantiate(String strategy) {
        if (driver == null) {
            DriverStrategyImplementer driverStrategyImplementer = new DriverStrategyImplementer();
            DriverStrategy driverStrategy = driverStrategyImplementer.chooseStrategy(strategy, appPackage, appActivity);
            driver = driverStrategy.setStrategy();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        }
        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static DriverSingleton getInstance(String driver, String appPackage, String appActivity) {
        if (instance == null) {
            instance = new DriverSingleton(driver, appPackage, appActivity);
        }
        return instance;
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized. Call getInstance() first.");
        }
        return driver;
    }

    public static void closeObjectInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        instance = null;
    }

}
