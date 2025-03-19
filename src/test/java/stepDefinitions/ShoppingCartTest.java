
package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Shoppingcartpage;
import utils.WebDriverSetup;

public class ShoppingCartTest {
    private WebDriver driver;
    private Shoppingcartpage shoppingcart;

    @Before
    public void setup() {
        driver = WebDriverSetup.getDriver("chrome");
        driver.manage().window().maximize();
        shoppingcart = new Shoppingcartpage(driver);
    }

    @Given("user is on the bookswagon page")
    public void loginpage() {
        driver.get("https://www.bookswagon.com");
    }

    @When("user enters valid credentials {string} and {string} login")
    public void Login_details(String username, String password) {
        shoppingcart.Account(username, password);
        System.out.println("Account logged in succesfully.......");
    }

    @When("user searches the product {string}")
    public void product_searching(String productname) {
        shoppingcart.product_searching(productname);
        System.out.println("producct name is :" + productname);
    }

    @When("user Adds three products to cart")
    public void addproducts_gotocart() throws InterruptedException {
        shoppingcart.addtocartfeature();
        System.out.println("adding products to the cart");
    }

    @Then("user should verify three products in the cart")
    public void productsverification() throws InterruptedException {
        Thread.sleep(1000);
        shoppingcart.cartcounting();
    }

    @When("user should remove two products from cart")
    public void removingproducts() throws InterruptedException {
        Thread.sleep(1000);
        shoppingcart.removeproductfromcart();
    }

    @Then("user should update quantity from cart")
    public void update_quantity() throws InterruptedException {
        shoppingcart.UpdateQuantity();
        System.out.println("product quantity updated.......");
    }

    @Then("user should click onn check out")
    public void checkoutprocess() throws InterruptedException {
        shoppingcart.checkout();
        Thread.sleep(3000);
    }

    @After
    public void teardown() {
        WebDriverSetup.quitDriver();
    }
}