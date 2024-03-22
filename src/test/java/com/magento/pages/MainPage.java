package com.magento.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    By logo = By.cssSelector(".logo");
    By search = By.cssSelector("#search");
    By menu = By.cssSelector("#store.menu");
    By cartIcon = By.cssSelector(".action.showcart");
    By checkoutBtn = By.cssSelector("#top-cart-btn-checkout");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String product){
        sendValues(search, product);
        pressEnter(search);
    }

    public void checkoutCart(){
        clickOnElement(cartIcon);
        clickOnElement(checkoutBtn);
    }

    public void goToOption(String option){
        getElementByInnerText(option).click();
    }
}
