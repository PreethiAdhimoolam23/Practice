
@tag
Feature: Purchase the order from e-commerce
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page


  @tag2
  Scenario Outline: Positive Test of Submittng the order
    Given I logged in with username <username> and password <password>
    When I add the Product <product> to cart
    And checkout  <product> is available and submit the order 
    Then "Thankyou for the order." is displayed. I verify the confirmation message 
    

    Examples: 
     | username | password | product |
     | preethiadhi@gmail.com | Preethi23 | ZARA COAT 3 |
