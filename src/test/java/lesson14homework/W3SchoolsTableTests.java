package lesson14homework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class W3SchoolsTableTests {
    // WebDriver instance
    static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        // Set up the ChromeDriver
        driver = new ChromeDriver();
        // Set implicit wait to handle dynamic elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void teardown() {
        // Close the browser after each test
        if (driver != null) {
           // driver.quit();
        }
    }

    // Task 3: W3Schools Table Tests
    @Test(priority = 1, description = "Test extracting and validating table data")
    public void w3SchoolsTableTest() {
        // Navigate to the W3Schools HTML Table page
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        // Locate the table element
        WebElement table = driver.findElement(By.id("customers"));
        // Verify that "Island Trading" exists in the table
        String company = table.findElement(By.xpath("//td[text()='Island Trading']")).getText();
        Assert.assertEquals(company, "Island Trading", "Company not found in table.");
        // Verify that "Maria Anders" is associated with "Alfreds Futterkiste"
        String contact = table.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td")).getText();
        Assert.assertEquals(contact, "Alfreds Futterkiste", "Contact does not match company.");
        // Count and validate the total number of rows in the table
        int rowCount = table.findElements(By.tagName("tr")).size();
        Assert.assertEquals(rowCount, 7, "Row count does not match expected value.");
    }
}
