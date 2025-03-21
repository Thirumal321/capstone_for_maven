Feature: User Registration and Login
@UserRegistrationTest

   
  Scenario: Automate the user registration process, login, and change password
    Given User on homepage
    When User registers an account
    When User logs in with mobile number "8555825415" and password "Test@123"
    When User changes the password "Test@123" to "Test@123"
    Then displays password changed successfully