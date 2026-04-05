package com.juaracoding.drivers.strategies;

public class DriverStrategyImplementer {

    public DriverStrategy chooseStrategy(String strategy) {
        return switch (strategy.toLowerCase()) {
            case "android" -> new AndroidManager();
            case "ios" -> new IOSManager();
            default -> throw new IllegalArgumentException("Unsupported strategy: " + strategy);
        };
    }

    public DriverStrategy chooseStrategy(String strategy, String appPackage, String appActivity) {
        return switch (strategy.toLowerCase()) {
            case "android" -> new AndroidManager(appPackage, appActivity);
            case "ios" -> new IOSManager();
            default -> throw new IllegalArgumentException("Unsupported strategy: " + strategy);
        };
    }

}
