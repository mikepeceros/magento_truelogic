package com.base;

import com.magento.utils.ScenarioContext;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getElementBy(By locator) {
    waitForElement(locator);
    return driver.findElement(locator);
  }

  public List<WebElement> getElementsBy(By locator) {
    waitForElement(locator);
    return driver.findElements(locator);
  }

  public void clickOnElement(By locator) {
    waitForElementToBeClickable(locator);
    driver.findElement(locator).click();
  }

  public String getElementTextBy(By locator) {
    return driver.findElement(locator).getText();
  }

  public void sendValues(By locator, String text) {
    waitForElementToBeClickable(locator);
    mouseover(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void selectOptionFromDropDownList(By locator, String textOption) {
    waitForElement(locator);
    List<WebElement> optionsList = driver.findElements(locator);
    optionsList.stream()
        .filter(e -> e.getText().trim().equalsIgnoreCase(textOption))
        .findFirst()
        .ifPresent(WebElement::click);
  }

  public void pressEnter(By locator) {
    waitForElement(locator);
    driver.findElement(locator).sendKeys(Keys.ENTER);
  }

  public void mouseover(By locator) {
    Actions action = new Actions(driver);
    action.moveToElement(getElementBy(locator)).perform();
  }

  public void mouseover(WebElement webElement) {
    Actions action = new Actions(driver);
    action.moveToElement(webElement).perform();
  }

  public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void waitForElement(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void waitForElementToBeClickable(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void waitForElementIsNotVisible(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public WebElement getElementByInnerText(String text){
    By.ByXPath byXPath = new By.ByXPath("//*[text()='"+text+"']");
    waitForElement(byXPath);
    return driver.findElement(byXPath);
  }
}
