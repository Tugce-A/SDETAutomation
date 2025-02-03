package lesson17.Guru99_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test99GuruLogin {

    // WebDriver instance to control the browser
    WebDriver driver;

    // Page object for the login page
    Guru99Login objLogin;

    // Page object for the home page
    Guru99HomePage objHomePage;

    @BeforeTest
    public void setup() {
        // Initialize the Firefox driver
        driver = new FirefoxDriver();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the Guru99 demo site
        driver.get("http://demo.guru99.com/V4/");
    }

    /**
     * This test case will:
     * - Navigate to the Guru99 demo site
     * - Verify the login page title as "Guru99 Bank"
     * - Attempt to log in with invalid credentials
     * - Verify the alert message for invalid credentials
     */

    @Test(priority = 0)
    public void test_login_invalid_creentials() {

        // Create an object of the login page
        objLogin = new Guru99Login(driver);

        // Verify the login page title contains "Guru99 Bank"
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        // Attempt to log in with invalid credentials
        objLogin.loginToGuru99("mgr123", "mgr!23");

        // Navigate to the next page (if login was successful)
        objHomePage = new Guru99HomePage(driver);

        // Verify the alert message when login fails
        String actualAlert = driver.switchTo().alert().getText();
        System.out.println(actualAlert);

        // Assert that the alert message matches the expected text
        Assert.assertEquals(actualAlert, "User or Password is not valid");
    }
}