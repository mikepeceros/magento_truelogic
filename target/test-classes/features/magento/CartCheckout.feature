Feature: Cart checkout

  Scenario: Single scenario to checkout cart
    When The user adds the next products
      | product name             | feature 1 | feature 2 |
      | Ajax Full-Zip Sweatshirt | M         | Green     |
      | Neve Studio Dance Jacket | XL        | Blue      |
      | Gwyn Endurance Tee       | XS        | Yellow    |
    And the user checkouts the cart
      | email              | firstName | LastName | Company | Street     | City | State   | ZipCode | Country | Phone     |
      | miguel@magento.com | Miguel    | Peceros  | Google  | Lima  2313 | Lima | Arizona | 13131   | Peru    | 944258351 |
    Then a success message is displayed
