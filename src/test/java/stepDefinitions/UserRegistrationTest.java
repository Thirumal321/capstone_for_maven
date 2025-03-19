package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserRegistrationPage;
import pages.productdetailspage;
import utils.WebDriverSetup;

public class UserRegistrationTest {
    WebDriver driver;
    WebDriverWait wait;
    UserRegistrationPage userRegistration;
    productdetailspage Productdetails;

    @Before("@UserRegistrationTest")
    public void setUp() {
        driver = WebDriverSetup.getDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        userRegistration = new UserRegistrationPage(driver);
        Productdetails = new productdetailspage(driver);
    }

    @Given("User on homepage")
    public void user_on_homepage() {
        driver.get("https://www.bookswagon.com/");
    }

    @When("User registers an account")
    public void user_register() {
        userRegistration.registration();
    }

    @When("User logs in with mobile number {string} and password {string}")
    public void userlogin(String username, String password) {
        userRegistration.user_login(username, password);
    }

    @When("User changes the password {string} to {string}")
    public void password_Change(String oldpass, String newpass) {
        userRegistration.passwordchange(oldpass, newpass);
    }

    @Then("displays password changed successfully")
    public void passwordverification() {
        Assert.assertTrue(userRegistration.passwordverify(), "password not changed");
    }

    @After("@UserRegistrationTest")
    public void tearDown() {
        WebDriverSetup.quitDriver();
    }
}