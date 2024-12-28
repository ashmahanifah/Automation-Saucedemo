Feature: Test Automation Web

  @web
  Scenario: Login with valid credentials
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list


  @web
  Scenario: Login with invalid credentials
    Given open url "https://www.saucedemo.com/"
    And user input username "invalid_user"
    And user input password "wrong_password"
    Then user should see an error message "Epic sadface: Username and password do not match any user in this service"

  @web
  Scenario: Filter products by price (low to high)
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    And user selects "Price (low to high)" from the sorting dropdown
    Then the products should be sorted in ascending order of price

  @web
  Scenario: Add a product to the cart
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    When user click the "Add to cart" button for a product
    Then the cart icon should display the number "1"
    And the product should appear in the cart

  @web
  Scenario: Remove a product from the cart
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    When user click the "Add to cart" button for a product
    Then the cart icon should display the number "1"
    And the product should appear in the cart
    When user click the "Remove" button for a product
    Then the cart icon should display the number "0"

  @web
  Scenario: Proceed to checkout
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    When user click the "Add to cart" button for a product
    Then the cart icon should display the number "1"
    When user click the cart icon
    And user click the "Checkout" button on the inventory cart page
    Then user should be redirected to the checkout information page

  @web
  Scenario: Successful checkout
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    When user click the "Add to cart" button for a product
    Then the cart icon should display the number "1"
    When user click the cart icon
    And user click the "Checkout" button on the inventory cart page
    Then user should be redirected to the checkout information page
    When user enter "John" as the first name
    And user enter "Doe" as the last name
    And user enter "12345" as the postal code
    And user click the "Continue" button on the checkout page
    And user click the "Finish" button on the checkout overview page
    Then user should see a confirmation message "THANK YOU FOR YOUR ORDER"

  @web
  Scenario: Missing information during checkout process
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    When user click the "Add to cart" button for a product
    Then the cart icon should display the number "1"
    When user click the cart icon
    And user click the "Checkout" button on the inventory cart page
    Then user should be redirected to the checkout information page
    When user leave the first name field empty
    Then user should see an error message "Error: First Name is required"

  @web
  Scenario: Logout
    Given open url "https://www.saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    Then user click login button
    Then user should see the product list
    And user click the "burger" button
    And user click the Logout button
    Then user should be redirected to the login page






