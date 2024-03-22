package com.magento.steps;

import com.magento.AppTestRun;
import com.magento.pages.MainPage;
import com.magento.pages.ProductSearchPage;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class ProductSearchSteps extends AppTestRun {

  MainPage mainPage = pageObjectManager.getMainPage();
  ProductSearchPage productSearchPage = pageObjectManager.getProductSearchPage();

  @When("The user adds the next products")
  public void theUserAddsTheNextProducts(DataTable dataTable) {
    List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
    for (Map<String, String> row : rows) {
      mainPage.searchProduct(row.get("product name"));
      productSearchPage.specifyProductSpecs(row.get("feature 1"), row.get("feature 2"));
    }
  }
}
