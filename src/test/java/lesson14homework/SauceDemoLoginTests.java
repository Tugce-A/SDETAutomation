package lesson14homework;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemoLoginTests {
    // WebDriver instance
    static WebDriver driver;

    @BeforeEach
    public void setup() {
        // Set up the ChromeDriver
        driver = new ChromeDriver();
        // Set implicit wait to handle dynamic elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        // Close the browser after each test
        if (driver != null) {
            // driver.quit();
        }
    }

    // Task 2: Sauce Demo Login Tests
    @Test()
    public  void sauceDemoLoginTest() {
        // Navigate to the Sauce Demo login page
        driver.get("https://www.saucedemo.com/");
        // Enter valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click the login button
        driver.findElement(By.id("login-button")).click();
        // Validate the inventory page is displayed
        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
        Assertions.assertTrue(inventoryContainer.isDisplayed(), "Inventory page is not displayed.");
        // Log out from the application
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        // Validate the login page is displayed after logout
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assertions.assertTrue(loginButton.isDisplayed(), "Logout was not successful.");
    }
}
