package lesson13;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAssertions {

    static WebDriver driver; // Static WebDriver instance for the class

    /**
     * This method is executed once before all test methods in the class.
     * - Sets up the WebDriver instance.
     * - Maximizes the browser window.
     */
    @BeforeClass
    public static void setupTest() {
        driver = new ChromeDriver(); // Initializes the ChromeDriver instance
        driver.manage().window().maximize(); // Maximizes the browser window
    }

    /**
     * This test simply prints "Hello World" to the console.
     * - The test will fail if it does not complete within 10 milliseconds.
     */
    @Test(timeout = 10) // Specifies a timeout of 10 milliseconds
    public void testconsole() {
        System.out.println("Hello World"); // Prints "Hello World" to the console
    }

    /**
     * This test navigates to a specified URL, retrieves the page title,
     * and validates it against an expected title using assertions.
     * - The test will fail if it does not complete within 5000 milliseconds.
     */
    @Test(timeout = 5000) // Specifies a timeout of 5000 milliseconds
    public void getURL() {
        driver.get("https://netrd.orioninc.com.tr/"); // Navigates to the specified URL
        String actualTitle = driver.getTitle(); // Retrieves the actual page title
        String expectedTitle = "NetRD"; // Expected title for validation

        // Asserts that the actual title matches the expected title
        Assert.assertEquals(actualTitle, expectedTitle);

        // Asserts that the actual title contains the expected title
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /**
     * This test is currently disabled due to a blocking issue.
     * - The test is ignored and will not be executed.
     */
    @Ignore("Test is disabled for blocking issue.") // Disables the test with a reason
    @Test
    public void checkTitle() {
        System.out.println("check title"); // Placeholder for the test logic
    }

    /**
     * This method is executed once after all test methods in the class.
     * - Closes the WebDriver instance and releases resources.
     */
    @AfterClass
    public static void tearDown() {
        driver.quit(); // Closes the browser and ends the WebDriver session
    }
}
