package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
   
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        // Check if the WebDriver instance is already initialized.
        if (driver == null) {
            // Use a switch statement to handle different browser types.
            switch (browser.toLowerCase()) {
                // Initialize ChromeDriver if "chrome" is specified.
                case "chrome":
                    WebDriverManager.chromedriver().setup(); // Setup ChromeDriver using WebDriverManager.
                    driver = new ChromeDriver(); // Create a new ChromeDriver instance.
                    break;
                // Initialize EdgeDriver if "edge" is specified.
                case "edge":
                    WebDriverManager.edgedriver().setup(); // Setup EdgeDriver using WebDriverManager.
                    driver = new EdgeDriver(); // Create a new EdgeDriver instance.
                    break;
                // Throw an exception for invalid browser types.
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        }
        // Return the WebDriver instance.
        return driver;
    }

   
    public static void quitDriver() {
        // Check if the WebDriver instance is initialized.
        if (driver != null) {
            driver.quit(); // Quit the WebDriver instance.
            driver = null; // Set the WebDriver instance to null.
        }
    }
}