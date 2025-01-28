package lesson16;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotExample {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open a website
            driver.get("https://www.google.com");

            // Take a screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);

            // Save the screenshot
            FileUtils.copyFile(screenshot, new File("src/test/java/lesson16/takescreenshotgoogle.jpeg"));
            System.out.println("Screenshot saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }
}
