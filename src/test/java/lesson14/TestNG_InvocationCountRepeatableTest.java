package lesson14;

// Import necessary Selenium and TestNG libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_InvocationCountRepeatableTest {

    WebDriver driver; // WebDriver instance to control the browser

    // This method runs before the class starts, setting up the WebDriver and browser settings
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize the browser window
    }

    // Test method to navigate to LinkedIn's homepage
    // This test will execute 3 times due to the invocationCount attribute
    @Test(invocationCount = 3)
    public void goToLinkedin() {
        driver.get("https://linkedin.com/"); // Navigate to LinkedIn
        String PageTitle = driver.getTitle(); // Retrieve the page title
        System.out.println(PageTitle); // Print the page title to the console
    }

    // Test method to navigate to Google's homepage
    // This test will execute 2 times due to the invocationCount attribute
    @Test(invocationCount = 2,description = "test",priority = 2,dependsOnMethods = "goToLinkedin")
    public void goToGoogle() {
        driver.get("https://google.com/"); // Navigate to Google
        String PageTitle = driver.getTitle(); // Retrieve the page title
        System.out.println(PageTitle); // Print the page title to the console
    }

    // A simple test method to demonstrate additional functionality
    @Test
    public void test() {
        System.out.println("test1234"); // Print a message to the console
    }

    // This method runs after the class has finished executing all test methods
    // It closes the browser and releases WebDriver resources
    @AfterClass
    public void tearDown() {
        driver.quit(); // Quit the browser and terminate the WebDriver instance
    }
}
