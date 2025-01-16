package lesson14;

// Import necessary Selenium and TestNG libraries
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonProductSearchTest {

    WebDriver driver; // WebDriver instance to control the browser

    // Setup method to initialize the WebDriver and browser settings
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize the browser window
    }

    // Test method to perform a product search on Amazon
    @Test
    public void searchProduct() {
        driver.get("https://www.amazon.com/"); // Navigate to Amazon's homepage
        try {
            Thread.sleep(20000); // Wait for 20 seconds to ensure the page loads completely
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Handle the interrupted exception
        }
        WebElement searchArea = driver.findElement(By.id("twotabsearchtextbox")); // Locate the search box by its ID
        searchArea.click(); // Click on the search box to focus
        searchArea.sendKeys("Quality Assurance" + Keys.ENTER); // Enter the search term and press Enter
    }

    // Teardown method to close the browser after the test execution
    @AfterClass
    public void tearDown() {
      //  driver.quit(); // Close the browser and terminate the WebDriver instance
    }
}