package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class iFramesCalculating {
    public static void main(String[] args) {
        // Call the method to calculate the number of iframes on the page
        iFrameCalculation();
    }

    public static void iFrameCalculation() {
        // Initialize the WebDriver (Chrome browser)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the target URL
        driver.get("https://demo.guru99.com/test/guru99home/");

        // Use WebDriverWait to wait for the iframe elements to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        // First way: Find all iframe elements using the <iframe> tag
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());

        // Second way: Use JavaScript to calculate the number of iframes
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        // Close the browser session to free resources
        driver.quit();
    }
}
