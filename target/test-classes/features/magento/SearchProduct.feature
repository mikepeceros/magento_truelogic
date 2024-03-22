Feature: Search Product

  Scenario Outline: Single scenario to checkout cart
    When The user searches a product "<Product>"
    Examples:
      | Product |
      | Jacket  |
      | Pants   |