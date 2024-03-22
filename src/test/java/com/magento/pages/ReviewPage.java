package com.magento.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewPage extends BasePage {

  By placeOrder = By.cssSelector("button[title='Place Order']");

  public ReviewPage(WebDriver driver) {
    super(driver);
  }

  public void placeOrder() {
    clickOnElement(placeOrder);
  }
}
