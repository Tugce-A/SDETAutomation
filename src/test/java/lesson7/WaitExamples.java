package lesson7;

// Import necessary Selenium and Java libraries

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; // Import for handling time durations

import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function; // Import for Functional interface

public class WaitExamples {
    public static void main(String[] args) {

        // Step 1: Initialize WebDriver
        // This creates an instance of the Chrome browser using the ChromeDriver
        WebDriver driver = new ChromeDriver();



        // Step 2: Implicit Wait
        // An implicit wait is applied globally and waits for an element to appear in the DOM before throwing an exception.
        // Here, the implicit wait is set to 10 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 3: Open a specific web page
        // The `get()` method loads the specified URL in the browser window.
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Step 4: Locate and click the Start button
        // Find the button using its CSS selector and click on it to trigger dynamic content loading.
        driver.findElement(By.cssSelector("#start button")).click();
        WebElement helloworld= driver.findElement(By.id("finish"));
        System.out.println("Text: " + helloworld.getText());

        // Step 5: Explicit Wait
        // Explicit wait allows us to wait for a specific condition to be met before proceeding further.
        // Here, we wait up to 10 seconds for the element with ID 'finish' to become visible.
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishElement = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );

        // Print the text of the element that appears after the wait condition is satisfied.
        System.out.println("Text found using Explicit Wait: " + finishElement.getText());

        // Step 6: Fluent Wait
        // Fluent wait allows more control over polling frequency and exception handling.
        // Here, the wait duration is 15 seconds, polling happens every 1 second, and NoSuchElementException is ignored.
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(1)) // Interval between checks
                .ignoring(NoSuchElementException.class); // Ignore this exception during the wait

        // First way - Define Function:
        // Define the condition to wait for using a Function
  /*      WebElement fluentElement = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish")); // Locate the element dynamically
            }
        });*/

        // Second way - Lambda Function:
            // Define the wait condition using a lambda expression.
            // - `fluentWait.until(...)`: This method applies the waiting logic.
            // - `driver1 ->`: Represents the WebDriver instance passed to the lambda function.
            // - `driver.findElement(By.id("finish"))`: The condition being checked repeatedly,
            //    which attempts to locate the element with the ID "finish".
            // - If the element is found during polling, it is returned as a WebElement.
            // - If not, FluentWait continues polling until the timeout period is reached.
        WebElement fluentElement = fluentWait.until(driver1 -> driver.findElement(By.id("finish")));


        // Print the text of the element located using Fluent Wait
        System.out.println("Text found using Fluent Wait: " + fluentElement.getText());

        // Step 7: Close the browser
        // Uncomment the line below if you want to close the browser after execution.
        // driver.quit();
    }
}