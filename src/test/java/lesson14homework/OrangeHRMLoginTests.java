package lesson14homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLoginTests {
    // WebDriver instance to manage browser interactions
    static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Set implicit wait to handle dynamic elements globally
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void teardown() {
        // Close the browser after each test execution
        if (driver != null) {
            // Uncomment to fully close the browser after the test
            // driver.quit();
        }
    }

    // Task 4: Test case for validating OrangeHRM login functionality
    @Test(description = "Test logging into OrangeHRM with valid and invalid credentials")
    public void orangeHRMLoginTest() {
        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // **Valid Login Test**
        // Enter username for valid login
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        // Enter password for valid login
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        // Click on the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Wait until the profile picture element is visible on the dashboard
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/img[@alt=\"profile picture\"]")));
        // Assert that the profile picture is displayed
        Assert.assertTrue(profile.isDisplayed());
        System.out.println("Logged in successfully");
        // Click on the profile picture to open the dropdown menu
        profile.click();

        // **Logout Test**
        // Locate and click the logout button
        WebElement logoutButton = driver.findElement(By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]"));
        logoutButton.click();
        System.out.println("Logged out successfully");

        // **Invalid Login Test**
        // Enter invalid username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("TestUser");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("WrongPass");
        // Click on the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // **Validation of Error Message**
        // Wait until the error message is visible
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-alert.oxd-alert--error")));
        // Assert that the error message is displayed
        Assert.assertTrue(alertMessage.isDisplayed());
        System.out.println("Invalid credentials");
    }
}
