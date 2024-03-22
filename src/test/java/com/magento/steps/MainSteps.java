package com.magento.steps;

import com.magento.AppTestRun;
import com.magento.pages.CheckoutPage;
import com.magento.pages.MainPage;
import com.magento.pages.ReviewPage;
import com.magento.pages.SalesPage;
import com.magento.pages.ShippingPage;
import com.magento.utils.Context;
import com.magento.utils.Order;
import com.magento.utils.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import java.util.Map;

public class MainSteps extends AppTestRun {

  MainPage mainPage = pageObjectManager.getMainPage();
  ShippingPage shippingPage = pageObjectManager.getShippingPage();
  ReviewPage reviewPage = pageObjectManager.getReviewPage();
  CheckoutPage checkoutPage = pageObjectManager.getCheckoutPage();
  SalesPage salesPage = pageObjectManager.getSalesPage();

  @When("The user searches a product {string}")
  public void theUserSearchesAProduct(String product) {
    mainPage.searchProduct(product);
  }

  @And("the user checkouts the cart")
  public void theUserCheckoutsTheCart(DataTable dataTable)throws InterruptedException {
    mainPage.checkoutCart();
    shippingPage.waitForForm();

    Order order = getOrder(dataTable);
    shippingPage.fillOrderForm(order);
    pageObjectManager.setContext(Context.ORDER, order);

    //shippingPage.selectShippingMethod(); TODO
    shippingPage.completeOrder();
    shippingPage.waitForProcessCompleted();
    reviewPage.placeOrder();
  }

  @And("the user notices the order number")
  public void theUserNoticesTheOrderNumber() {
    Order order = (Order) pageObjectManager.getContext(Context.ORDER);
    order.setOrderNumber(checkoutPage.getOrderNumber());
  }

  private Order getOrder(DataTable dataTable) {
    Map<Object, Object> row = dataTable.asMaps(String.class, String.class).get(0);
    Order order = new Order();
    order.setMail(row.get("email").toString());
    order.setFirstName(row.get("firstName").toString());
    order.setLastName(row.get("LastName").toString());
    order.setCompany(row.get("Company").toString());
    order.setStreetAddress(row.get("Street").toString());
    order.setCity(row.get("City").toString());
    order.setState(row.get("State").toString());
    order.setCountry(row.get("Country").toString());
    order.setZip(row.get("ZipCode").toString());
    order.setPhone(row.get("Phone").toString());
    return order;
  }

  @When("the user goes to {string}")
  public void theUserGoesTo(String arg0) {
    mainPage.goToOption(arg0);
  }

  @And("the user finds the order created")
  public void theUserFindsTheOrderCreated() {
    Order order = (Order) pageObjectManager.getContext(Context.ORDER);
    salesPage.findOrder(order);
  }

  @Then("the order is found correctly")
  public void theOrderIsFoundCorrectly() {
    Order order = (Order) pageObjectManager.getContext(Context.ORDER);
    salesPage.verifyOrder(order);
  }
}
