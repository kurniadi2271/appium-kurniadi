package com.juaracoding.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public class ProductPage extends BasePage {

    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    @iOSXCUITBy(accessibility = "sortBtn")
    private WebElement sortButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price - Ascending\"]")
    @iOSXCUITBy(accessibility = "priceAscCL")
    private WebElement sortPriceLowToHigh;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price - Descending\"]")
    @iOSXCUITBy(accessibility = "priceDesCL")
    private WebElement sortPriceHighToLow;
    
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[1]")
    @iOSXCUITBy(accessibility = "productItem1")
    private WebElement firstProductItem;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    @iOSXCUITBy(accessibility = "cartBt")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    @iOSXCUITBy(accessibility = "cartIV")
    private WebElement cartIcon;

    public void clickSortButton() {
        sortButton.click();
    }

    public void sortByPriceLowToHigh() {
        clickSortButton();
        sortPriceLowToHigh.click();
    }

    public void sortByPriceHighToLow() {
        clickSortButton();
        sortPriceHighToLow.click();
    }

    public void selectFirstProduct() {
        firstProductItem.click();
    }

    public void goToCart() {
        cartIcon.click();
    }
    
    public void addProductToCart() {
        addToCartButton.click();
    }
    
    public void scrollToAddToCartButton() {
        scrollToElementById("com.saucelabs.mydemoapp.android:id/cartBt");
    }
}