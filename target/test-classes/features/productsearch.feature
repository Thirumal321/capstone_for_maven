Feature: Product Details Page Validation and Actions

  Scenario: Validate product details and add to wishlist/cart
    Given User is on the Bookswagon homepage
    When User logs in with valid credentials "8555825415" and "Test@123"
    And User searches for a product "java"and clicks on product
    And User should validate the product title, description, price, images, and availability
    When User adds the product to the wishlist
    When User adds the product to the cart
    Then The product should be added to the cart and wishlist successfully
    Then user should remove products
 