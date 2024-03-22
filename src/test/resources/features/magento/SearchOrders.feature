Feature: Search Orders

  Scenario: Single scenario to checkout cart
    Given The user adds the next products
      | product name | feature 1 | feature 2 |
      | Aether Gym   | 33        | Brown     |
      | Capri        | 28        | Blue      |
    And the user checkouts the cart
      | email              | firstName | LastName | Company | Street     | City | State   | ZipCode | Country | Phone     |
      | miguel@magento.com | Miguel    | Peceros  | Google  | Lima  2313 | Lima | Arizona | 13131   | Peru    | 944258351 |
    And the user notices the order number
    When the user goes to "Orders and Returns"
    And the user finds the order created
    Then the order is found correctly
