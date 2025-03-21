
package stepDefinitions;
import pages.HomePage;
import utils.ScreenshotUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homepage;

    @Given("User is on the Bookswagon home page")
    public void user_is_on_the_bookswagon_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homepage = new HomePage(driver);
        driver.get("https://www.bookswagon.com");
    }

    @Then("Search bar should be displayed")
    public void search_bar_should_be_displayed() {
        homepage.searchbutton();
    }

    @When("User searches for Product {string}")
    public void user_searches_for(String searchText) {
        homepage.searchingforproduct(searchText);
        homepage.booktitile();
        driver.close();
    }

   @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}