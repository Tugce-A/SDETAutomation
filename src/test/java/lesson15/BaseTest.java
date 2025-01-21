package lesson15;

// Importing necessary classes for WebDriver and TestNG functionalities
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    // WebDriver instance to control the browser
    WebDriver driver;

    // Instance of SoftAssert for performing soft assertions in tests
    SoftAssert softAssert;

    // This method runs before the first test in the class
    @BeforeClass
    public void setup() {
        // Initializing the Chrome WebDriver instance
        driver = new ChromeDriver();

        // Initializing the SoftAssert instance
        softAssert = new SoftAssert();

        // Maximizing the browser window for better visibility during tests
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        System.out.println("test");
    }
    // This method runs after all tests in the class have executed
    @AfterClass
    public void tearDown() {
        // Closing the browser and cleaning up WebDriver resources
        driver.quit();

        // Validating all soft assertions made during the tests
        softAssert.assertAll();
    }
}
