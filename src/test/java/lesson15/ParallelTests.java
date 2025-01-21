package lesson15;

// Importing necessary classes for WebDriver and TestNG functionalities
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTests {
    // WebDriver instance to control the browser
    WebDriver driver;

    // Setup method runs before the tests and initializes the WebDriver based on the browser parameter
    @Parameters({"browser"}) // Accepts "browser" parameter for parallel execution
    @BeforeClass
    public void setup(String browser) {
        // Switch case to handle browser selection
        switch (browser) {
            case "edge":
                // Initializes EdgeDriver for Edge browser
                driver = new EdgeDriver();
                break;
            case "chrome":
                // Initializes ChromeDriver for Chrome browser
                driver = new ChromeDriver();
                break;
            default:
                // Throws an exception if an invalid browser name is provided
                throw new IllegalArgumentException("Check browser name");
        }
    }

    // Test method to validate the title of LinkedIn's homepage
    @Test
    public void getTitleForLinkedin() {
        // Introducing a delay to simulate real-world conditions (not recommended in actual test automation)
        try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Handle the interrupted exception
        }

        // Navigates to LinkedIn's homepage
        driver.get("https://linkedin.com/");

        // Introducing another delay to allow page loading (not recommended in production)
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Handle the interrupted exception
        }

        // Retrieves the page title
        String PageTitle = driver.getTitle();

        // Prints the page title to the console
        System.out.println(PageTitle);

        // Validates that the page title matches the expected title
        Assert.assertEquals(PageTitle, "LinkedIn: Log In or Sign Up");
    }

    // Teardown method to close the browser after all tests are executed
    @AfterClass
    public void tearDown() {
        // Cleans up resources by closing the browser (currently commented out)
        // Uncomment the line below to enable browser closing
        // driver.quit();
    }
}
