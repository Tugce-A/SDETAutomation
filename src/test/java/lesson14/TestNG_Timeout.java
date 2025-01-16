package lesson14;

// Import necessary Selenium and TestNG libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Timeout {

    WebDriver driver; // WebDriver instance to control the browser

    // This method runs before the class starts, setting up the WebDriver
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
    }

    // Test 1: Navigate to Amazon and fetch the page title
    // The test must complete within 1500 milliseconds, or it will fail
    @Test(timeOut = 1500)
    public void pageTitleAmazon() {
        driver.get("https://www.amazon.com"); // Navigate to Amazon's homepage
        String PageTitle = driver.getTitle(); // Retrieve the page title
        System.out.println("Page Title is: " + PageTitle); // Print the page title to the console
    }

    // Test 2: Navigate to Orion and fetch the page title
    // The test must complete within 500 milliseconds, or it will fail
    @Test(timeOut = 500)
    public void pageTitleOrion() {
        driver.get("https://www.orioninc.com/"); // Navigate to Orion's homepage
        String PageTitle = driver.getTitle(); // Retrieve the page title
        System.out.println("Page Title is: " + PageTitle); // Print the page title to the console
    }

    // This method runs after all test methods in the class are executed
    // Used to release resources and clean up
    @AfterClass
    public void closeTests() {
        // Uncomment the below line to close the browser after tests
        // driver.quit();
    }
}