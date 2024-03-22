package com.magento.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductSearchPage extends BasePage {

  By productInfo = By.cssSelector(".product-item-info");
  By productItem = By.cssSelector(".product-item-name");
  By productSizes = By.cssSelector("[id*='option-label-size']");
  By productColors = By.cssSelector("[id*='option-label-color']");
  By addButton = By.cssSelector(".action.tocart.primary");
  By productAddedMsg = By.cssSelector(".message-success");

  public ProductSearchPage(WebDriver driver) {
    super(driver);
  }

  public void specifyProductSpecs(String size, String color) {
    WebElement productElement = getElementsBy(productInfo).get(0);
    scrollToElement(productElement);

    selectColor(productElement, color);
    selectSize(productElement, size);

    productElement.findElement(addButton).click();
    //waitForElement(productAddedMsg); bug
  }

  private void selectColor(WebElement productElement, String color) {
    mouseover(productElement);

    List<WebElement> colors = productElement.findElements(productColors);
    colors.stream()
            .filter(e -> e.getAttribute("aria-label").equals(color))
            .findFirst()
            .ifPresent(WebElement::click);
  }

  private void selectSize(WebElement productElement, String size) {
    List<WebElement> sizes = productElement.findElements(productSizes);
    sizes.stream()
            .filter(e -> e.getText().equals(size))
            .findFirst()
            .ifPresent(WebElement::click);
  }
}
