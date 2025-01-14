package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://the-internet.herokuapp.com/windows");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Get the handle of the original window
            String originalWindow = driver.getWindowHandle();

            // Click the link to open a new window
            WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
            clickHereLink.click();

            // Wait for the new window to open (basic wait for demo purposes)
            Thread.sleep(2000);

            // Get all window handles
            Set<String> windowHandles = driver.getWindowHandles();

            // Switch to the new window
            for (String handle : windowHandles) {
                if (!handle.equals(originalWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Validate the new window's title
            String newWindowTitle = driver.getTitle();
            if (newWindowTitle.equals("New Window")) {
                System.out.println("Test Passed: New window title is correct.");
            } else {
                System.out.println("Test Failed: Expected 'New Window' but got '" + newWindowTitle + "'.");
            }

            // Close the new window
            driver.close();

            // Switch back to the original window
            driver.switchTo().window(originalWindow);
            System.out.println("Back to the original window. Title: " + driver.getTitle());
            System.out.println("Back to the original window. URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}