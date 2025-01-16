package lesson14;

// Import necessary Selenium and TestNG libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_DependsOnMethods {

    WebDriver driver; // WebDriver instance for controlling the browser

    // Setup method to initialize WebDriver and browser settings
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize the browser window
    }

    // Test method to fetch and validate the title of the LinkedIn page
    // This method depends on the successful execution of the goToLinkedin() method
    @Test(dependsOnMethods = "goToLinkedin")
    public void getTitleForLinkedin() {
        try {
            Thread.sleep(2000); // Wait for 2 seconds to allow the page to load fully
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Handle any interruptions during the wait
        }
        String PageTitle = driver.getTitle(); // Get the title of the current page
        System.out.println(PageTitle); // Print the page title to the console
        // Assert that the page title matches the expected title
        Assert.assertEquals(PageTitle, "LinkedIn: Log In or Sign Up");
    }

    // Test method to navigate to the LinkedIn homepage
    // The invocationCount attribute specifies the number of times this test should be executed
    @Test(invocationCount = 1)
    public void goToLinkedin() {
        driver.get("https://linkedin.com/"); // Navigate to LinkedIn's homepage
    }

    // TearDown method to close the browser after all tests are executed
    @AfterClass
    public void tearDown() {
        driver.quit(); // Quit the browser and terminate the WebDriver instance
    }
}