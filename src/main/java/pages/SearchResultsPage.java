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

    @FindBy(id = "inputbar")private WebElement searchBar;

    @FindBy(id = "btnTopSearch")private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[4]/a") private WebElement Filter;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[2]/a") private WebElement price;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[3]/li[3]/a") private WebElement Discounts;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[8]/li[2]/a")private WebElement Language;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[1]/a")private WebElement close;

    @FindBy(css = "#site-wrapper > div.search-results.fltrs > div.right-column > div.result-heading > div.search-summary.search-heading > h1") private WebElement searchResults;

    public SearchResultsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searcharea(String productname) {

        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(productname);
    }

    public void searchButton(){
        searchButton.click();
    }

   /* public void filterbutton() {
    	wait.until(ExpectedConditions.elementToBeClickable(Filter)).click();
    }*/
    public void pricebutton() {
        wait.until(ExpectedConditions.elementToBeClickable(price)).click();
    }

    public void discountbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(Discounts)).click();
        
    }

    public void languagebutton() {
        wait.until(ExpectedConditions.elementToBeClickable(Language)).click();
        
    }


    public boolean issearchresultsdisplayed() {
    	
            wait.until(ExpectedConditions.visibilityOf(searchResults));
            
            return searchResults.isDisplayed();
            }
}