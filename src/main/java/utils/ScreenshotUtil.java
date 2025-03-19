package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

 public static void captureScreenshot(WebDriver driver, String screenshotName) {
     try {
         TakesScreenshot ts = (TakesScreenshot) driver;
         File source = ts.getScreenshotAs(OutputType.FILE);
         String destination = "C:\\Users\\thiru\\eclipse-workspace\\Capstone_Project" + screenshotName + ".png";
         File finalDestination = new File(destination);
         FileUtils.copyFile(source, finalDestination);
         System.out.println("Screenshot captured: " + destination);
     } catch (IOException e) {
         System.out.println("Failed to capture screenshot: " + e.getMessage());
     }
 }
}