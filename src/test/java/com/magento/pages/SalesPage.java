package com.magento.pages;

import com.base.BasePage;
import com.magento.utils.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesPage extends BasePage {

    By orderId = By.id("oar-order-id");
    By billingLastName = By.id("oar-billing-lastname");
    By mail = By.id("oar_email");
    By continueBtn = By.cssSelector(".primary");

    public SalesPage(WebDriver driver) {
        super(driver);
    }

    public void findOrder(Order order){
        sendValues(orderId, order.getOrderNumber());
        sendValues(billingLastName, order.getLastName());
        sendValues(mail, order.getMail());
        clickOnElement(continueBtn);
    }

    public void verifyOrder(Order order){
        // verify details
        // verify products
    }
}
