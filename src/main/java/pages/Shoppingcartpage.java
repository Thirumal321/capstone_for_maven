package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Shoppingcartpage {

    private WebDriverWait wait;

    // Constructor to initialize the Page Object.
    public Shoppingcartpage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locators for account login.
    @FindBy(id = "ctl00_lblUser")
    private WebElement accountclick;
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    private WebElement userid;
    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    private WebElement pass;
    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    private WebElement LoginButton;

    // Locators for product search.
    @FindBy(id = "inputbar")
    private WebElement searchBar;
    @FindBy(id = "btnTopSearch")
    private WebElement searchButton;

    // Locators for adding products to cart.
    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[1]/div[4]/div[5]/input[1]")
    private WebElement addtocartproduct1;
    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[4]/div[4]/div[4]/input[1]")
    private WebElement addtocartproduct2;
    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[8]/div[4]/div[4]/input[1]")
    private WebElement addtocartproduct3;

    // Locators for cart operations.
    @FindBy(id = "ctl00_lblTotalCartItems")
    private WebElement cartcount;
    @FindBy(id = "ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete")
    private WebElement removeproduct1;
    @FindBy(id = "ctl00_phBody_BookCart_lvCart_ctrl1_imgDelete")
    private WebElement removeproduct2;
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_BookCart_lvCart_ctrl0_btnPlus\"]")
    private WebElement updatequantity;
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_BookCart_lvCart_imgPayment\"]")
    private WebElement checkoutprocess;

    // Method to perform account login.
    public void Account(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(accountclick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userid)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(pass)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
    }

    // Method to search for a product.
    public void product_searching(String productname) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(productname);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    // Method to add products to the cart and navigate to the cart page.
    // Includes Thread.sleep for demonstration purposes (should be avoided in production).
    public void addtocartfeature() throws InterruptedException {
        Thread.sleep(2000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(addtocartproduct1)).click();
        Thread.sleep(2000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(addtocartproduct2)).click();
        Thread.sleep(2000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(addtocartproduct3)).click();
        Thread.sleep(2000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(cartcount)).click();
    }

    // Method to verify the cart count.
    public boolean cartcounting() {
        String Accart = wait.until(ExpectedConditions.elementToBeClickable(cartcount)).getText();
        String Eccart = "3";
        Assert.assertEquals(Accart, Eccart);
        System.out.println("Actual products in cart :" + Accart + " And Expected Cart products are " + Eccart);
        return false; // Returning false as testng assert will handle the pass/fail.
    }

    // Method to remove products from the cart.
    // Includes Thread.sleep for demonstration purposes (should be avoided in production).
    public void removeproductfromcart() throws InterruptedException {
        Thread.sleep(2000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(removeproduct1)).click();
        Thread.sleep(2000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(removeproduct2)).click();
    }

    // Method to update the quantity of a product in the cart.
    // Includes Thread.sleep for demonstration purposes (should be avoided in production).
    public void UpdateQuantity() throws InterruptedException {
        Thread.sleep(3000); // Avoid Thread.sleep, use explicit waits.
        int number = 4;
        for (int i = 0; i < number; i++)
            wait.until(ExpectedConditions.elementToBeClickable(updatequantity)).click();
    }

    // Method to proceed to checkout.
    // Includes Thread.sleep for demonstration purposes (should be avoided in production).
    public void checkout() throws InterruptedException {
        Thread.sleep(3000); // Avoid Thread.sleep, use explicit waits.
        wait.until(ExpectedConditions.elementToBeClickable(checkoutprocess)).click();
    }
}