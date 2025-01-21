package lesson14homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ComputerDatabaseTests {
    // WebDriver instance for browser interaction
    WebDriver driver;

    @Before
    public void setup() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        // Set implicit wait to manage synchronization with dynamic elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        // Close the browser after each test execution
        if (driver != null) {
            // Uncomment this line to close the browser after tests
            // driver.quit();
        }
    }

    @Test
    public void computerDatabaseTest() {
        // Navigate to the computer database application homepage
        driver.get("http://computer-database.gatling.io");

        // **Adding a New Computer**
        // Locate and click the "Add a new computer" button
        driver.findElement(By.id("add")).click();

        // Fill in the "Name" field with the computer name
        driver.findElement(By.id("name")).sendKeys("JUnit4 Test Computer");
        // Fill in the "Introduced" date field
        driver.findElement(By.id("introduced")).sendKeys("2025-01-01");
        // Fill in the "Discontinued" date field
        driver.findElement(By.id("discontinued")).sendKeys("2026-01-01");

        // **Selecting a Company**
        // Locate the "Company" dropdown
        WebElement company = driver.findElement(By.name("company"));
        // Create a Select object and select "Apple Inc." by its visible text
        Select dropCompany = new Select(company);
        dropCompany.selectByVisibleText("Apple Inc.");

        // **Submitting the Form**
        // Locate and click the "Create this computer" button
        driver.findElement(By.cssSelector(".btn.primary")).click();

        // **Validation**
        // Expected success message after adding a new computer
        String expectedText = "Done ! Computer JUnit4 Test Computer has been created";
        // Actual success message displayed on the page
        String actualText = driver.findElement(By.cssSelector("div.alert-message.warning")).getText();
        // Assert that the expected and actual messages are equal
        Assert.assertEquals(expectedText, actualText);
    }
}
