package pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productdetailspage{
private WebDriverWait wait;
public productdetailspage(WebDriver driver) {
	  this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	 PageFactory.initElements(driver, this);

}
//account_login
@FindBy(id="ctl00_lblUser") private WebElement accountclick;
@FindBy(id="ctl00_phBody_SignIn_txtEmail")private WebElement userid;
@FindBy(id="ctl00_phBody_SignIn_txtPassword")private WebElement pass;
@FindBy(id="ctl00_phBody_SignIn_btnLogin")private WebElement LoginButton;
//search for product
@FindBy(id = "inputbar")private WebElement searchBar;
@FindBy(id = "btnTopSearch")private WebElement searchButton;
//book data
@FindBy(xpath="//*[@id=\"listSearchResult\"]/div[2]/div[3]/div[1]/a")private WebElement Booklink;
//validating the product details
@FindBy(id= "ctl00_phBody_ProductDetail_lblTitle")private WebElement productTitle;
@FindBy(id = "ctl00_phBody_ProductDetail_lblLongDesc")private WebElement productDescription;
@FindBy(id= "ctl00_phBody_ProductDetail_lblourPrice")private WebElement productPrice;
@FindBy(id = "ctl00_phBody_ProductDetail_imgProduct")private WebElement productImage;
@FindBy(id = "ctl00_phBody_ProductDetail_lblAvailable")private WebElement productAvailability;
@FindBy(id="btnAddtocart")private WebElement addtocartbutton;
@FindBy(xpath="//*[@id=\"bordercornerbox\"]/div/a")private WebElement addtowishlistbutton;
@FindBy(id="ctl00_lblTotalCartItems")private WebElement cartcount;
@FindBy(id="ctl00_lblWishlistCount")private WebElement wishlistccount;
@FindBy(id="ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete") private WebElement removecartElement;
@FindBy(id="ctl00_phBody_WishList_lvWishList_ctrl0_ImageButton1") private WebElement removewishlistelement;


public void Account(String username,String password) {
	
	wait.until(ExpectedConditions.elementToBeClickable(accountclick)).click();
	wait.until(ExpectedConditions.elementToBeClickable(userid)).sendKeys(username);
	wait.until(ExpectedConditions.elementToBeClickable(pass)).sendKeys(password);
	wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
	
}
public void searching_product(String productname) {
	wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(productname);
	wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	wait.until(ExpectedConditions.elementToBeClickable(Booklink)).click();
}
public String getProductTitle() {
	System.out.println( productTitle.getText());
    return productTitle.getText();
}

public boolean isDescriptionDisplayed() {
	System.out.println("prodduct description:"+productDescription.getText());
    return productDescription.isDisplayed();
}

public boolean isPriceDisplayed() {
	System.out.println( "price of the product is:"+productPrice.getText());
    return productPrice.isDisplayed();
}

public boolean isImageDisplayed() {
    return productImage.isDisplayed();
}

public boolean isProductAvailable() {
	System.out.println("product is :"+productAvailability.getText());
    return productAvailability.isDisplayed();
}
public void addToCart() {
	wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton)).click();
}
public void addToWishlist() {
	wait.until(ExpectedConditions.elementToBeClickable(addtowishlistbutton)).click();
}


public void cartandwishlistcount() {
	wait.until(ExpectedConditions.elementToBeClickable(cartcount)).getText();
	wait.until(ExpectedConditions.elementToBeClickable(wishlistccount)).getText();
	
}
public void removecartandwishlistitems() {
	wait.until(ExpectedConditions.elementToBeClickable(cartcount)).click();
	wait.until(ExpectedConditions.elementToBeClickable(removecartElement)).click();
	wait.until(ExpectedConditions.elementToBeClickable(wishlistccount)).click();
	wait.until(ExpectedConditions.elementToBeClickable(removewishlistelement)).click();
}
 }