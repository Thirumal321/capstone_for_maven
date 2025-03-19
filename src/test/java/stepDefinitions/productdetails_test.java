package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.productdetailspage;
import utils.WebDriverSetup;
import java.io.IOException;

public class productdetails_test {

    private WebDriver driver;
    private productdetailspage productDetailsPage;

    @Before
    public void setup() {
        driver = WebDriverSetup.getDriver("chrome");
        driver.manage().window().maximize();
        productDetailsPage = new productdetailspage(driver);
    }

    @Given("User is on the Bookswagon homepage")
    public void user_is_on_the_bookswagon_homepage() {
        driver.get("https://www.bookswagon.com/");
    }

    @When("User logs in with valid credentials {string} and {string}")
    public void user_logs_in_with_valid_credentials(String username, String password) throws IOException {
        productDetailsPage.Account(username, password);
    }

    @When("User searches for a product {string}and clicks on product")
    public void user_searches_for_a_product_and_clicks_on_product(String productName) {
        productDetailsPage.searching_product(productName);
    }

    @When("User should validate the product title, description, price, images, and availability")
    public void user_should_validate_the_product_title_description_price_images_and_availability() {
        Assert.assertNotNull(productDetailsPage.getProductTitle());
        Assert.assertTrue(productDetailsPage.isDescriptionDisplayed());
        Assert.assertTrue(productDetailsPage.isPriceDisplayed());
        Assert.assertTrue(productDetailsPage.isImageDisplayed());
        Assert.assertTrue(productDetailsPage.isProductAvailable());
    }

    @When("User adds the product to the wishlist")
    public void user_adds_the_product_to_the_wishlist() {
        productDetailsPage.addToWishlist();
    }

    @When("User adds the product to the cart")
    public void user_adds_the_product_to_the_cart() {
        productDetailsPage.addToCart();
    }

    @Then("The product should be added to the cart and wishlist successfully")
    public void the_product_should_be_added_to_the_cart_and_wishlist_successfully() {
        productDetailsPage.cartandwishlistcount();
    }

    @Then("user should remove products")
    public void remove_items() {
        productDetailsPage.removecartandwishlistitems();
    }

    @After
    public void tearDown() {
        WebDriverSetup.quitDriver();
    }
}
