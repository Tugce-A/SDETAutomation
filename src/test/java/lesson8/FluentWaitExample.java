package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        // Creating a FluentWait object for WebDriver to wait for an element to appear.
// This allows flexible waiting with custom timeout, polling interval, and exception handling.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                // Sets the maximum wait time to 30 seconds.
                .withTimeout(Duration.ofSeconds(30L))
                // Specifies that the element should be checked every 5 seconds.
                .pollingEvery(Duration.ofSeconds(5L))
                // Ignores NoSuchElementException during the waiting period to avoid unnecessary test failures.
                .ignoring(NoSuchElementException.class);

// Using FluentWait to wait until a specific condition is met.
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            // The `apply` method is defined without using the @Override annotation.
            // This method checks whether the element with the specified ID is present on the page.
            public WebElement apply(WebDriver driver) {
                // Attempts to locate the element with ID "foo".
                // If the element is found, it is returned and the waiting ends.
                // If the element is not found, FluentWait retries based on the polling interval.
                return driver.findElement(By.id("foo"));
            }
        });

    }
}
