package lesson17.LoginTestSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestDriver {

    // WebDriver instance to control the browser
    WebDriver driver;

    // Page object for the login page
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        // Initialize the Edge WebDriver
        driver = new EdgeDriver();

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Navigate to the SauceDemo website
        driver.get("https://www.saucedemo.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time to allow elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /*
    @AfterClass
    public void tearDown() {
        // Close the browser after the test is complete
        driver.quit();
    }
    */
}