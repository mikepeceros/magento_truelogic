package com.magento.pages;

import com.base.BasePage;
import com.magento.utils.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ShippingPage extends BasePage {

  By form = By.cssSelector("#shipping");
  By mail = By.cssSelector("#customer-email");
  By firstName = By.cssSelector("input[name='firstname']");
  By lastName = By.cssSelector("input[name='lastname']");
  By company = By.cssSelector("input[name='company']");
  By streetAddress = By.cssSelector("input[name='street[0]']");
  By city = By.cssSelector("input[name='city']");
  By state = By.cssSelector("select[name='region_id'] > option");
  By zip = By.cssSelector("input[name='postcode']");
  By country = By.cssSelector("select[name='country_id'] > option");
  By phone = By.cssSelector("input[name='telephone']");
  By shippingMethods = By.cssSelector("#checkout-shipping-method-load tbody tr");
  By nextBtn = By.cssSelector(".continue.primary");
  By loading = By.cssSelector("img[alt='Loading...']");

  public ShippingPage(WebDriver driver) {
    super(driver);
  }

  public void waitForForm() {
    waitForElement(form);
  }

  public void fillOrderForm(Order order) {
    sendValues(mail, order.getMail());
    sendValues(firstName, order.getFirstName());
    sendValues(lastName, order.getLastName());
    sendValues(company, order.getCompany());
    sendValues(streetAddress, order.getStreetAddress());
    selectOptionFromDropDownList(
        country,
        order.getCountry()); // enhancement to report, country must be displayed above the state
    sendValues(city, order.getCity());
    selectOptionFromDropDownList(state, order.getState());
    sendValues(zip, order.getZip());
    sendValues(phone, order.getPhone());
  }

  public void selectShippingMethod() {
    List<WebElement> shippingMethodElements = getElementsBy(shippingMethods);
    waitForElementToBeClickable(shippingMethods);
    shippingMethodElements.get(0).click();
  }

  public void completeOrder()throws InterruptedException {
    Thread.sleep(4000); //TODO enhancement
    clickOnElement(nextBtn);
  }

  public void waitForProcessCompleted() {
    waitForElement(loading);
    waitForElementIsNotVisible(loading);
  }
}
