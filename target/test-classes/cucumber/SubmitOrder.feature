
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of purchasing order
    Given Logged in with username<name> and password<password>
    When I add product<productName> to cart
    and checkout <productName> and submit the order
    Then THANKYOU FOR THE ORDER.message is displayed on confirmation page

    Examples: 
      | name         | password      |productName
      | mayuri@yahoo.com | Mayuri@29 | ZARA COAT 3
      
