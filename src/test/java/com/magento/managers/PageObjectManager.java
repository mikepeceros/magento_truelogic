package com.magento.managers;

import com.magento.pages.CheckoutPage;
import com.magento.pages.MainPage;
import com.magento.pages.ProductSearchPage;
import com.magento.pages.ReviewPage;
import com.magento.pages.SalesPage;
import com.magento.pages.ShippingPage;
import com.magento.utils.Context;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class PageObjectManager {

    private RemoteWebDriver webDriver;
    protected MainPage mainPage;
    protected ProductSearchPage productSearchPage;
    protected ShippingPage shippingPage;
    protected ReviewPage reviewPage;
    protected CheckoutPage checkoutPage;
    protected SalesPage salesPage;
    private Map<String, Object> scenarioContext;

    public PageObjectManager(RemoteWebDriver driver) {
        this.webDriver = driver;
        scenarioContext = new HashMap<>();
    }

    public MainPage getMainPage(){
        return (mainPage == null) ? mainPage = new MainPage(webDriver) : mainPage;
    }

    public ProductSearchPage getProductSearchPage(){
        return (productSearchPage == null) ? productSearchPage = new ProductSearchPage(webDriver) : productSearchPage;
    }

    public ShippingPage getShippingPage(){
        return (shippingPage == null) ? shippingPage = new ShippingPage(webDriver) : shippingPage;
    }

    public ReviewPage getReviewPage(){
        return (reviewPage == null) ? reviewPage = new ReviewPage(webDriver) : reviewPage;
    }

    public CheckoutPage getCheckoutPage(){
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(webDriver) : checkoutPage;
    }

    public SalesPage getSalesPage(){
        return (salesPage == null) ? salesPage = new SalesPage(webDriver) : salesPage;
    }

    public void setContext(Context key, Object value){
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }
}
