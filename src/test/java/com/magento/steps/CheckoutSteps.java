package com.magento.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.magento.AppTestRun;
import com.magento.pages.CheckoutPage;
import com.magento.utils.Context;
import com.magento.utils.Order;
import com.magento.utils.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CheckoutSteps extends AppTestRun {

    CheckoutPage checkoutPage = pageObjectManager.getCheckoutPage();

    @Then("a success message is displayed")
    public void aSuccessMessageIsDisplayed() {
        String actualMsg = checkoutPage.getMsg();
        assertThat(actualMsg).contains("Your order # is");
        assertThat(actualMsg).contains("We'll email you an order confirmation with details and tracking info");
    }

}
