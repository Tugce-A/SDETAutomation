package lesson14;

// Import necessary Selenium and TestNG libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Description {

    static WebDriver driver; // WebDriver instance for browser control

    // This method runs before each test to set up the WebDriver and navigate to the test page
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize browser window
        driver.get("https://practicetestautomation.com/practice-test-login/"); // Navigate to the login page
    }

    // Test 1: Verify successful login with valid user credentials
    @Test(description = "it is part of smoke testing, P2")
    public void validCredentialsLogin() {
        // Locate username field and enter valid credentials
        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        // Locate password field and enter valid password
        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        // Locate and click the login button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify the post-login success message
        WebElement postTitleElement = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));
        String postTitleElementText = postTitleElement.getText();
        String expectedPostTitleText = "Logged In Successfully";

        // Verify the congratulatory message
        WebElement postContentElement = driver.findElement(By.cssSelector(".has-text-align-center strong"));
        String postContentText = postContentElement.getText();
        String expectedPostContentText = "Congratulations student. You successfully logged in!";

        // Print messages for debugging
        System.out.println("Post Title Element Text is: " + postTitleElementText);
        System.out.println("Post Content Text is: " + postContentText);

        // Assert to verify actual and expected results match
        Assert.assertEquals(expectedPostTitleText, postTitleElementText);
        Assert.assertEquals(expectedPostContentText, postContentText);
    }

    // Test 2: Verify error message for invalid username with valid password
    @Test(priority = 3)
    public void invalidUsernameAndValidPasswordLogin() {
        // Enter invalid username and valid password
        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys("inValidUsername");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Wait for error message to appear
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify the error message is displayed
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessageElementText = errorMessageElement.getText();
        System.out.println("Error message is: " + errorMessageElementText);

        String expectedErrorMessageElementText = "Your username is invalid!";

        // Verify conditions for error message content and visibility
        boolean firstErrorMessageElementCondition = errorMessageElementText.contains("Your username is invalid!");
        boolean secondErrorMessageElementCondition = errorMessageElement.isDisplayed();

        // Debugging information
        System.out.println("Boolean Condition of text contains is: " + firstErrorMessageElementCondition);
        System.out.println("Boolean Condition of element is Displayed: " + secondErrorMessageElementCondition);

        // Assert to verify the error message and conditions
        Assert.assertEquals(expectedErrorMessageElementText, errorMessageElementText);
        Assert.assertTrue(firstErrorMessageElementCondition, "Please check first boolean");
        Assert.assertTrue(secondErrorMessageElementCondition, "Please check second boolean");

        System.out.println("Location: " + errorMessageElement.getLocation());
    }

    // Test 3: Verify error message for valid username with invalid password
    @Test(priority = 1, enabled = true, description = "disabled because it is not part of smoke testing", invocationCount = 8)
    public void validUsernameAndInValidPasswordLogin() {
        // Enter valid username and invalid password
        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("InvalidPassword");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Wait for error message to appear
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify the error message is displayed
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessageElementText = errorMessageElement.getText();
        System.out.println("Error message is: " + errorMessageElementText);

        String expectedErrorMessageElementText = "Your password is invalid!";

        // Verify conditions for error message content and visibility
        boolean firstErrorMessageElementCondition = errorMessageElementText.contains("Your password is invalid!");
        boolean secondErrorMessageElementCondition = errorMessageElement.isDisplayed();

        // Debugging information
        System.out.println("Boolean Condition of text contains is: " + firstErrorMessageElementCondition);
        System.out.println("Boolean Condition of element is Displayed: " + secondErrorMessageElementCondition);

        // Assert to verify the error message and conditions
        Assert.assertEquals(expectedErrorMessageElementText, errorMessageElementText);
        Assert.assertTrue(firstErrorMessageElementCondition, "Please check first boolean");
        Assert.assertTrue(secondErrorMessageElementCondition, "Please check second boolean");

        System.out.println("Location: " + errorMessageElement.getLocation());
    }

    // This method runs after each test to close the browser
    @AfterMethod
    public void tearDown() {
        driver.quit(); // Quit the browser and terminate the WebDriver instance
    }
}
