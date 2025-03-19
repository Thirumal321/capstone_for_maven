package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

    private WebDriverWait wait;

    @FindBy(id = "inputbar")
    private WebElement searchBar;
    @FindBy(id = "btnTopSearch")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[1]/a")
    private WebElement Booktitle;

    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searchbutton() {
        // verifying searchbar is displayed or not
        Assert.assertTrue(searchBar.isDisplayed());

    }

    public void searchingforproduct(String Book) {
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(Book);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

    }

    public void booktitile() {
        // verifying searchbar by searching any one book
        String actualbooktitle = Booktitle.getText();
        String expectedbooktitile = "JAVA THE COMPLETE REFERENCE, 13E";
        Assert.assertEquals(actualbooktitle, expectedbooktitile);

    }
}