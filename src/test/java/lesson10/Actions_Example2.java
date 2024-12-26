package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Actions_Example2 {
    public static void main(String[] args) {
        // Base URL of the website to be tested
        String baseUrl = "http://www.facebook.com/";
        // Base URL of the website to be tested
        WebDriver driver = new FirefoxDriver();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the specified URL in the browser
        driver.get(baseUrl);

        // Locate the username text field by its ID
        WebElement txtUsername = driver.findElement(By.id("email"));

        // Create an instance of the Actions class to build a series of actions
        Actions builder = new Actions(driver);

        // Build a series of actions:
        // - Move to the username text field
        // - Click on it
        // - Hold down the SHIFT key
        // - Type "hello" in uppercase
        // - Release the SHIFT key
        // - Double-click the text field
        // - Perform a right-click (context click)
        Action seriesOfActions = builder
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)
                .contextClick()
                .build();

        // Perform the series of actions
        seriesOfActions.perform() ;

        // Print "Test" to the console to confirm execution
        System.out.println("Test");
    }
}
