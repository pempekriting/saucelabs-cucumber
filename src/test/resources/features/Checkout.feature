Feature: Checkout

  Background:
    Given the app is launched
    And the user is on the catalog

  @Checkout
  Scenario Outline: Checkout a single product
    When the user adds "<product>" color "<color>" quantity <qty> to the cart
    And proceeds to checkout
    And logs in with valid credentials
    And provides shipping details
    And provides payment details
    And the order summary shows
    Then the order is confirmed

    Examples:
      | product               | color       | qty |
      | Sauce Lab Back Packs  | Blue color  | 2   |
