package com.magento.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

  By msg = By.cssSelector(".checkout-success");

  public CheckoutPage(WebDriver driver) {
    super(driver);
  }

  public String getMsg() {
    return getElementTextBy(msg);
  }

  public String getOrderNumber() {
    WebElement msgElement = getElementBy(msg);
    return msgElement.findElement(By.cssSelector("span")).getText();
  }
}
