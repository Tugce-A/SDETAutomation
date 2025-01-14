package lesson13;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebExamples {

        static WebDriver driver; // Static WebDriver instance for the class

    /**
     * This method is executed once before all test methods in the class.
     * - Initializes the WebDriver instance (ChromeDriver).
     * - Sets up the environment for the tests.
     */
    @BeforeClass
    public static void preparation() {
        driver = new ChromeDriver(); // Initializes the ChromeDriver instance
    }

    /**
     * This test navigates to Amazon's homepage and retrieves the page title.
     * - Validates that the WebDriver can navigate to the URL successfully.
     * - Prints the page title to the console for verification.
     */
    @Test
    public void loginValidCredentials() {
        driver.get("https://www.amazon.com"); // Navigates to Amazon's homepage
        String PageTitle = driver.getTitle(); // Retrieves the page title
        System.out.println("Page Title is: " + PageTitle); // Prints the page title to the console
    }

    /**
     * This test navigates to Orion's website and retrieves the page title.
     * - Validates that the WebDriver can navigate to the URL successfully.
     * - Prints the page title to the console for verification.
     */
    @Test
    public void Test2() {
        driver.get("https://www.orioninc.com/"); // Navigates to Orion's website
        String PageTitle = driver.getTitle(); // Retrieves the page title
        System.out.println("Page Title is: " + PageTitle); // Prints the page title to the console
    }

    /**
     * This method is executed once after all test methods in the class.
     * - Closes the WebDriver instance to clean up resources.
     */
    @AfterClass
    public static void closeTests() {
      //  driver.quit(); // Closes the browser and ends the WebDriver session
    }
}
