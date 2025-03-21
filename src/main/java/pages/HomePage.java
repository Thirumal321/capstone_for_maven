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

    // Using @FindBy annotations to locate web elements.
    // This makes the code more readable and maintainable.
    @FindBy(id = "inputbar")
    private WebElement searchBar;

    @FindBy(id = "btnTopSearch")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[1]/a")
    private WebElement Booktitle;

    // Constructor to initialize the Page Object.
    // PageFactory.initElements initializes the web elements using the @FindBy annotations.
    // WebDriverWait is initialized to handle explicit waits.
    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a timeout.
        PageFactory.initElements(driver, this); // Initialize web elements.
    }

    // Method to verify if the search bar is displayed.
    // Using Assert.assertTrue for verification.
    public void searchbutton() {
        // verifying searchbar is displayed or not
        Assert.assertTrue(searchBar.isDisplayed()); // Check if the search bar is visible.
    }

    // Method to search for a product (book).
    // Uses explicit waits (WebDriverWait) to ensure elements are interactable.
    public void searchingforproduct(String Book) {
        // Wait for the search bar to be visible and then send the search term.
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(Book);

        // Wait for the search button to be clickable and then click it.
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    // Method to verify the book title after search.
    // Uses Assert.assertEquals to compare the actual and expected book titles.
    public void booktitile() {
        // verifying searchbar by searching any one book
        String actualbooktitle = Booktitle.getText(); // Get the actual book title from the web element.
        String expectedbooktitile = "JAVA THE COMPLETE REFERENCE, 13E"; // Define the expected book title.

        // Assert that the actual title matches the expected title.
        Assert.assertEquals(actualbooktitle, expectedbooktitile);
    }
}