# Testing Mobile App - Sauce Labs Demo App

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)]()
[![Java Version](https://img.shields.io/badge/Java-21-blue)]()
[![Maven](https://img.shields.io/badge/Maven-3.6.0+-blue)]()
[![TestNG](https://img.shields.io/badge/TestNG-7.12.0-blue)]()

Automated test suite for the Sauce Labs My Demo App using Appium, Selenium WebDriver, TestNG, and Maven. This project demonstrates best practices in mobile test automation with a comprehensive page object model architecture.

## 📋 Table of Contents

- [Features Tested](#-features-tested)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Running Tests](#-running-tests)
- [Test Configuration](#-test-configuration)
- [Project Architecture](#-project-architecture)
- [Test Documentation](#-test-documentation)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)

## ✅ Features Tested

- **Login Module** 🔐
  - Successful login with valid credentials
  - Invalid login error handling
  - Session management

- **Product Catalog** 📦
  - View product list with details
  - Sort products by price (low-to-high & high-to-low)
  - Product details and images

- **Shopping Cart** 🛒
  - Add products to cart
  - View cart contents
  - Remove items from cart
  - Cart quantity updates

- **Checkout & Payment** 💳
  - Complete checkout workflow
  - Shipping information entry
  - Payment processing
  - Order confirmation

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 21 | Programming language |
| **Selenium WebDriver** | 4.41.0 | Web element interaction |
| **Appium** | 10.1.0 | Mobile app automation |
| **TestNG** | 7.12.0 | Test framework & reporting |
| **Maven** | 3.6.0+ | Build & dependency management |
| **Android SDK** | 25+ | Mobile platform support |

## 📁 Project Structure

```
testing-mobile-app/
├── src/
│   ├── main/java/com/juaracoding/
│   │   ├── App.java                                    # Main application class
│   │   ├── drivers/
│   │   │   ├── DriverSingleton.java                    # Singleton pattern for driver
│   │   │   └── strategies/
│   │   │       ├── DriverStrategy.java                 # Strategy interface
│   │   │       ├── DriverStrategyImplementer.java      # Strategy implementation
│   │   │       ├── AndroidManager.java                 # Android-specific driver setup
│   │   │       └── IOSManager.java                     # iOS-specific driver setup
│   │   └── pages/
│   │       ├── BasePage.java                           # Base page object
│   │       ├── LoginPage.java                          # Login page object
│   │       ├── ProductPage.java                        # Product listing page object
│   │       └── CartPage.java                           # Cart/Checkout page object
│   └── test/java/com/juaracoding/
│       ├── LoginTest.java                              # Login test cases
│       ├── ProductTest.java                            # Product test cases
│       └── CartTest.java                               # Cart & checkout test cases
├── pom.xml                                              # Maven configuration
├── testng.xml                                           # TestNG configuration
├── README.md                                            # This file
                                                         
```

## 📋 Prerequisites

Before running the tests, ensure you have the following installed:

### System Requirements
- **OS:** Windows 10/11 or macOS/Linux
- **Java:** JDK 21 or higher
- **Maven:** 3.6.0 or higher
- **RAM:** 4GB minimum (8GB recommended)
- **Disk Space:** 2GB free space

### Software Dependencies
- **Appium Server:** 2.0 or higher
- **Android SDK:** API Level 25 or higher
- **npm:** For Appium installation

### Mobile Setup
- Android emulator (Android 7.0+) or physical device
- Sauce Labs My Demo App APK installed on device
- USB debugging enabled (if using physical device)

## 🚀 Installation & Setup

### Step 1: Verify Java Installation
```bash
java -version
# Expected: Java 21 or higher
```

### Step 2: Verify Maven Installation
```bash
mvn -version
# Expected: Apache Maven 3.6.0 or higher
```

### Step 3: Install Appium Server
```bash
npm install -g appium
appium --version
# Expected: 2.0.0 or higher

# Install Android driver for Appium (optional, auto-installed with Appium 2.0)
appium driver install uiautomator2
```

### Step 4: Setup Android Environment
```bash
# Install Android Studio with SDK
# Set ANDROID_HOME environment variable
# Example on Windows:
setx ANDROID_HOME "C:\Users\YourUsername\AppData\Local\Android\Sdk"

# Verify ADB installation
adb version
```

### Step 5: Create/Connect Android Device
```bash
# List available emulators
emulator -list-avds

# Start an emulator
emulator -avd your_emulator_name

# OR list connected physical devices
adb devices
```

### Step 6: Install Sauce Labs My Demo App
```bash
# Download APK from Sauce Labs or via direct link
adb install path/to/SauceLabs-Demo-App.apk
```

### Step 7: Clone & Setup Repository
```bash
# Clone the repository
git clone <repository-url>
cd testing-mobile-app

# Install Maven dependencies
mvn clean install

# Verify setup (optional)
mvn validate
```

## 🧪 Running Tests

### Run All Tests
```bash
# Basic run
mvn clean test

# With detailed output
mvn clean test -X

# With test reports
mvn clean test surefire-report:report
```

### Run Specific Test Classes
```bash
# Test Login functionality
mvn clean test -Dtest=LoginTest

# Test Product features
mvn clean test -Dtest=ProductTest

# Test Cart & Checkout
mvn clean test -Dtest=CartTest
```

### Run with TestNG XML Configuration
```bash
# Run with testng.xml
mvn clean test -Dsuites=testng.xml

# Run specific test from XML
mvn clean test -Dtest=LoginTest#testSuccessfulLogin
```

### Advanced Execution Options
```bash
# Run single test method
mvn clean test -Dtest=LoginTest#testSuccessfulLogin

# Run tests in parallel (faster)
mvn clean test -DparallelSuites=5

# Skip tests (run without executing)
mvn clean install -DskipTests

# Generate HTML report only
mvn surefire-report:report
```

## ⚙️ Test Configuration

### TestNG Parameters (testng.xml)

All test parameters are defined in `testng.xml`:

```xml
<parameter name="mobile" value="android" />
<parameter name="appPackage" value="com.saucelabs.mydemoapp.android" />
<parameter name="appActivity" value="com.saucelabs.mydemoapp.android.view.activities.SplashActivity" />
<parameter name="username" value="bod@example.com" />
<parameter name="password" value="10203040" />
```

### Appium Server Configuration

The driver is initialized with these Appium capabilities:
```properties
platformName=Android
appPackage=com.saucelabs.mydemoapp.android
appActivity=com.saucelabs.mydemoapp.android.view.activities.SplashActivity
automationName=UiAutomator2
serverUrl=http://localhost:4723
```

## 🏗️ Project Architecture

### Design Patterns Used

1. **Page Object Model (POM)**
   - Separates test logic from page-specific code
   - Improves maintainability and reusability

2. **Singleton Pattern**
   - `DriverSingleton.java` - Ensures single WebDriver instance

3. **Strategy Pattern**
   - `DriverStrategy.java` - Allows pluggable driver implementations
   - Support for Android and iOS drivers

### Class Hierarchy

```
BasePage (Abstract)
├── LoginPage
├── ProductPage
└── CartPage

DriverSingleton (Singleton)
└── DriverStrategy (Strategy Interface)
    ├── AndroidManager
    └── IOSManager
```

## 📚 Test Documentation

Comprehensive test documentation is available in [SIT.md](SIT.md), which includes:

- 📋 **System Integration Test [SIT](https://docs.google.com/spreadsheets/d/1_9IPaR-niTyXGZakXKKBUdeTPFLeaiPi/edit?usp=drive_link&ouid=102556497230646308513&rtpof=true&sd=true) Plan**
- 📊 **Detailed Test Cases** (Login, Product, Cart, Checkout, E2E)
- 🧪 **Test Execution Guidelines**
- 📈 **Test Reporting & Metrics**
- ⚠️ **Risk Assessment & Mitigation**
- 🔧 **Troubleshooting Guide**
- 📝 **Test Data Reference**

## 📊 Test Reports

After running tests, reports are generated in:

```
target/surefire-reports/
├── index.html                          # Main HTML report
├── emailable-report.html               # Email-friendly format
├── testng-results.xml                  # XML format (TestNG)
├── junitreports/
│   ├── TEST-com.juaracoding.LoginTest.xml
│   ├── TEST-com.juaracoding.ProductTest.xml
│   └── TEST-com.juaracoding.CartTest.xml
└── Mobile App Test Suite/
    ├── login-tests.html
    ├── product-tests.html
    └── cart-tests.html
```

**View Reports:**
```bash
# Open HTML report in browser (Windows)
start target\surefire-reports\index.html

# macOS/Linux
open target/surefire-reports/index.html
```

## 🔧 Troubleshooting

### Issue: "Unable to start Appium Server"
**Solution:**
```bash
# Ensure npm is installed
npm install -g appium

# Start Appium with debug mode
appium --port 4723 --log-level debug
```

### Issue: "Android device not found"
**Solution:**
```bash
# Restart ADB
adb kill-server
adb start-server

# List connected devices
adb devices

# Enable USB debugging on physical device
adb shell settings put global development_settings_enabled 1
```

### Issue: "App package not found"
**Solution:**
```bash
# Verify app installation
adb shell pm list packages | grep saucelabs

# Reinstall app
adb install -r path/to/app.apk
```

### Issue: "Test timeout or slow execution"
**Solution:**
- Increase implicit waits in `testng.xml`
- Use `WebDriverWait` instead of `Thread.sleep()`
- Verify device performance (close unnecessary apps)

### Issue: "Port 4723 already in use"
**Solution:**
```bash
# Find process using port 4723
netstat -ano | findstr :4723

# Kill the process
taskkill /PID <PID> /F

# Or start Appium on different port
appium --port 4724
```

## 📦 Maven Commands Reference

```bash
mvn clean                              # Remove target directory
mvn compile                            # Compile source code
mvn install                            # Install dependencies
mvn test                               # Run tests
mvn package                            # Package application
mvn clean install                      # Clean and install
mvn clean test -DskipTests             # Install without running tests
mvn surefire-report:report             # Generate test report
mvn help:describe -Dcmd=test           # Get help on test command
```

## 📝 Test Case Examples

### Example 1: Successful Login
```java
@Test(description = "Test Case: Successful Login")
@Parameters({"username", "password"})
public void testSuccessfulLogin(String username, String password) {
    loginPage.goToLoginPage();
    loginPage.login(username, password);
    // Verification happens in page object
}
```

### Example 2: Add to Cart & Checkout
```java
@Test(description = "Test Case: Checkout Process")
public void testCheckoutProcess() {
    productPage.selectProduct("Backpack");
    productPage.addToCart();
    cartPage.navigateToCheckout();
    cartPage.fillShippingInfo(/* parameters */);
    cartPage.fillPaymentInfo(/* parameters */);
    cartPage.completeOrder();
}
```

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Follow existing code style and conventions
4. Add test cases for new features
5. Commit changes (`git commit -m 'Add amazing feature'`)
6. Push to branch (`git push origin feature/amazing-feature`)
7. Open a Pull Request

## 📋 Prerequisites

1. Clone the repository
2. Install dependencies: `mvn clean install`
3. Start Appium server: `appium`
4. Start Android emulator or connect device
5. Run tests: `mvn test`

## Test Configuration

Tests are configured in `testng.xml` with parameters for:
- Mobile platform (android/ios)
- App package and activity
- Test data (username, password, shipping info, etc.)

## Running Tests

- **Login Tests**: `mvn test -Dtest=LoginTest`
- **Product Tests**: `mvn test -Dtest=ProductTest`
- **Cart Tests**: `mvn test -Dtest=CartTest`
- **SIT Tests**: `mvn test -Dtest=SITTest`
- **All Tests**: `mvn test`

## SIT (System Integration Test)

The `SITTest.java` contains end-to-end tests covering the full user flow from login to checkout.