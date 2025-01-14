package lesson13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RepeatedTestAnnotationJUnit5 {

    static WebDriver driver; // Static WebDriver instance for the class

    /**
     * This method sets up the WebDriver before all tests are executed.
     * - Initializes the ChromeDriver.
     * - Maximizes the browser window.
     * - Opens the LinkedIn homepage.
     */
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver(); // Initializes the ChromeDriver instance
        driver.manage().window().maximize(); // Maximizes the browser window
        driver.get("https://linkedin.com/"); // Navigates to LinkedIn's homepage
    }

    /**
     * This test retrieves and prints the page title of the LinkedIn homepage.
     * The test is repeated 5 times using the @RepeatedTest annotation.
     */
    @RepeatedTest(5) // Specifies that this test should run 5 times
    public void goToLinkedin() {
        String PageTitle = driver.getTitle(); // Retrieves the page title
        System.out.println(PageTitle); // Prints the page title to the console
    }
}
