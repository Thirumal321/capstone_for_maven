Feature: Shopping Cart Basics

  Scenario: Shopping cart action
  Given user is on the bookswagon page
  When user enters valid credentials "7286806073" and "Test@123" login
  When user searches the product "java" 
  When user Adds three products to cart
  Then user should verify three products in the cart
  When user should remove two products from cart
  Then user should update quantity from cart 
  Then user should click onn check out
  
 
  