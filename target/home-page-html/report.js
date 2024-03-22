$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/magento/SearchOrders.feature");
formatter.feature({
  "name": "Search Orders",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Single scenario to checkout cart",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The user adds the next products",
  "rows": [
    {
      "cells": [
        "product name",
        "feature 1",
        "feature 2"
      ]
    },
    {
      "cells": [
        "Aether Gym",
        "33",
        "Brown"
      ]
    },
    {
      "cells": [
        "Capri",
        "28",
        "Blue"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "ProductSearchSteps.theUserAddsTheNextProducts(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user checkouts the cart",
  "rows": [
    {
      "cells": [
        "email",
        "firstName",
        "LastName",
        "Company",
        "Street",
        "City",
        "State",
        "ZipCode",
        "Country",
        "Phone"
      ]
    },
    {
      "cells": [
        "miguel@magento.com",
        "Miguel",
        "Peceros",
        "Google",
        "Lima  2313",
        "Lima",
        "Arizona",
        "13131",
        "Peru",
        "944258351"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "MainSteps.theUserCheckoutsTheCart(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user notices the order number",
  "keyword": "And "
});
formatter.match({
  "location": "MainSteps.theUserNoticesTheOrderNumber()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user goes to \"Orders and Returns\"",
  "keyword": "When "
});
formatter.match({
  "location": "MainSteps.theUserGoesTo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user finds the order created",
  "keyword": "And "
});
formatter.match({
  "location": "MainSteps.theUserFindsTheOrderCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the order is found correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "MainSteps.theOrderIsFoundCorrectly()"
});
formatter.result({
  "status": "passed"
});
});