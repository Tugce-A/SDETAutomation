package lesson14homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WikipediaSearchTests {
    // WebDriver instance
    static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        // Set up the ChromeDriver
        driver = new ChromeDriver();
        // Set implicit wait to handle dynamic elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void teardown() {
        // Close the browser after each test
        if (driver != null) {
            // driver.quit();
        }
    }

    @Test
    public void wikipediaSearchTest() {
        // Navigate to the Wikipedia homepage
        driver.get("https://www.wikipedia.org/");
        // Search for "Selenium (software)"
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validate that the correct heading is displayed
        WebElement heading = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(heading.getText(), "Selenium (software)", "Incorrect heading displayed.");

        // Navigate to Selenium's official website
        driver.findElement(By.xpath("//a[contains(@href, 'https://selenium.dev')]")).click();
        // Switch to the new tab or window
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        // Validate that the Selenium homepage contains the expected text
        WebElement seleniumHeading = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(seleniumHeading.getText().contains("Selenium automates browsers"),
                "Selenium homepage does not contain expected text.");
    }
}
