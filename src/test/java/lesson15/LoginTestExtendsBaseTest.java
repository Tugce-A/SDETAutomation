package lesson15;

// Importing necessary classes for Selenium WebDriver and TestNG functionalities
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// This class extends BaseTest to inherit setup and teardown methods
public class LoginTestExtendsBaseTest extends BaseTest {



    // Test method to validate the login functionality
    @Test
    public void login() {
        // Navigates to the practice login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Locates the username input field by its ID and enters a valid username
        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        // Locates the password input field by its ID and enters a valid password
        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        // Locates the submit button by its ID and clicks it to submit the form
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Locates the post-login confirmation message by its XPath
        WebElement postTitleElement = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));

        // Retrieves the text of the confirmation message
        String postTitleElementText = postTitleElement.getText();

        // Defines the expected text for validation
        String expectedPostTitleText = "Logged In Successfully";

        // Adds a dummy soft assertion for illustration (this is incorrect and should be revised)
        softAssert.assertEquals("4", 2);

        // Asserts that the actual post-login message matches the expected message
        softAssert.assertEquals(expectedPostTitleText, postTitleElementText);
    }
}
