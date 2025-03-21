package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productdetailspage {

    private WebDriverWait wait;

    // Constructor to initialize the Page Object.
    // Initializes WebDriverWait and PageFactory.
    public productdetailspage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a timeout.
        PageFactory.initElements(driver, this); // Initialize web elements using PageFactory.
    }

    // Account Login Locators
    @FindBy(id = "ctl00_lblUser")
    private WebElement accountclick;
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    private WebElement userid;
    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    private WebElement pass;
    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    private WebElement LoginButton;

    // Search for Product Locators
    @FindBy(id = "inputbar")
    private WebElement searchBar;
    @FindBy(id = "btnTopSearch")
    private WebElement searchButton;

    // Book Data Locators
    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[2]/div[3]/div[1]/a")
    private WebElement Booklink;

    // Validating Product Details Locators
    @FindBy(id = "ctl00_phBody_ProductDetail_lblTitle")
    private WebElement productTitle;
    @FindBy(id = "ctl00_phBody_ProductDetail_lblLongDesc")
    private WebElement productDescription;
    @FindBy(id = "ctl00_phBody_ProductDetail_lblourPrice")
    private WebElement productPrice;
    @FindBy(id = "ctl00_phBody_ProductDetail_imgProduct")
    private WebElement productImage;
    @FindBy(id = "ctl00_phBody_ProductDetail_lblAvailable")
    private WebElement productAvailability;
    @FindBy(id = "btnAddtocart")
    private WebElement addtocartbutton;
    @FindBy(xpath = "//*[@id=\"bordercornerbox\"]/div/a")
    private WebElement addtowishlistbutton;
    @FindBy(id = "ctl00_lblTotalCartItems")
    private WebElement cartcount;
    @FindBy(id = "ctl00_lblWishlistCount")
    private WebElement wishlistccount;
    @FindBy(id = "ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete")
    private WebElement removecartElement;
    @FindBy(id = "ctl00_phBody_WishList_lvWishList_ctrl0_ImageButton1")
    private WebElement removewishlistelement;

    // Method to perform account login.
    // Uses explicit waits to ensure elements are interactable before performing actions.
    public void Account(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(accountclick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userid)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(pass)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
    }

    // Method to search for a product and navigate to its details page.
    // Uses explicit waits to ensure elements are interactable.
    public void searching_product(String productname) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(productname);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Booklink)).click();
    }

    // Method to get the product title and print it to the console.
    public String getProductTitle() {
        System.out.println(productTitle.getText()); // Print the product title to the console for debugging.
        return productTitle.getText(); // Return the product title.
    }

    // Method to check if the product description is displayed and print it to the console.
    public boolean isDescriptionDisplayed() {
        System.out.println("prodduct description:" + productDescription.getText()); // Print the product description to the console.
        return productDescription.isDisplayed(); // Return true if the description is displayed, false otherwise.
    }

    // Method to check if the product price is displayed and print it to the console.
    public boolean isPriceDisplayed() {
        System.out.println("price of the product is:" + productPrice.getText()); // Print the product price to the console.
        return productPrice.isDisplayed(); // Return true if the price is displayed, false otherwise.
    }

    // Method to check if the product image is displayed.
    public boolean isImageDisplayed() {
        return productImage.isDisplayed(); // Return true if the image is displayed, false otherwise.
    }

    // Method to check if the product availability is displayed and print it to the console.
    public boolean isProductAvailable() {
        System.out.println("product is :" + productAvailability.getText()); // Print the product availability to the console.
        return productAvailability.isDisplayed(); // Return true if the availability is displayed, false otherwise.
    }

    // Method to add the product to the cart.
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton)).click();
    }

    // Method to add the product to the wishlist.
    public void addToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(addtowishlistbutton)).click();
    }

    // Method to get the cart and wishlist counts.
    public void cartandwishlistcount() {
        wait.until(ExpectedConditions.elementToBeClickable(cartcount)).getText(); // Get cart count.
        wait.until(ExpectedConditions.elementToBeClickable(wishlistccount)).getText(); // Get wishlist count.
    }

    // Method to remove items from the cart and wishlist.
    public void removecartandwishlistitems() {
        wait.until(ExpectedConditions.elementToBeClickable(cartcount)).click(); // Navigate to cart.
        wait.until(ExpectedConditions.elementToBeClickable(removecartElement)).click(); // Remove from cart.
        wait.until(ExpectedConditions.elementToBeClickable(wishlistccount)).click(); // Navigate to wishlist.
        wait.until(ExpectedConditions.elementToBeClickable(removewishlistelement)).click(); // Remove from wishlist.
    }
}