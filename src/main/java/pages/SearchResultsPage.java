package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private WebDriverWait wait;

    // Locators for search functionality.
    @FindBy(id = "inputbar")
    private WebElement searchBar;

    @FindBy(id = "btnTopSearch")
    private WebElement searchButton;

    // Locators for filter options.
    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[4]/a")
    private WebElement Filter;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[2]/a")
    private WebElement price;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[3]/li[3]/a")
    private WebElement Discounts;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[8]/li[2]/a")
    private WebElement Language;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[1]/a")
    private WebElement close;

    // Locator for search results heading.
    @FindBy(css = "#site-wrapper > div.search-results.fltrs > div.right-column > div.result-heading > div.search-summary.search-heading > h1")
    private WebElement searchResults;

    // Constructor to initialize the Page Object.
    public SearchResultsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to enter a product name in the search bar.
    public void searcharea(String productname) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(productname);
    }

    // Method to click the search button.
    public void searchButton() {
        searchButton.click();
    }

    // Method to click the price filter button.
    // Includes a Thread.sleep for demonstration purposes (should be avoided in production).
    public void pricebutton() throws InterruptedException {
        Thread.sleep(2000); // Avoid using Thread.sleep, use explicit waits instead.
        wait.until(ExpectedConditions.elementToBeClickable(price)).click();
    }

    // Method to click the discount filter button.
    // Includes a Thread.sleep for demonstration purposes (should be avoided in production).
    public void discountbutton() throws InterruptedException {
        Thread.sleep(2000); // Avoid using Thread.sleep, use explicit waits instead.
        wait.until(ExpectedConditions.elementToBeClickable(Discounts)).click();
    }

    // Method to click the language filter button.
    // Includes a Thread.sleep for demonstration purposes (should be avoided in production).
    public void languagebutton() throws InterruptedException {
        Thread.sleep(2000); // Avoid using Thread.sleep, use explicit waits instead.
        wait.until(ExpectedConditions.elementToBeClickable(Language)).click();
    }

    // Method to check if search results are displayed.
    public boolean issearchresultsdisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        return searchResults.isDisplayed();
    }
}