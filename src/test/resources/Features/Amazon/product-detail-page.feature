Feature: Observe Product Detail Page Action

  Scenario: As a non login User, I want to see product detail page at amazon.in
    Given the user is on the Amazon Page
    When he click on Hamburger Menu
    And click on TV, Appliances and Electronics under Shop by Department sections
    And click on Televisions under Tv, Audio & Cameras sub sections
    And check the filter for Brand Samsung
    And sort the filter result with price from high to low
    And click the second highest priced item
    And switch to the product detail opened in new tab
    Then the detail product section named with "About this item"

