package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumDevDynamicPage {
    public static void main(String[] args) {
        // Create a new WebDriver instance for Microsoft Edge
        WebDriver driver = new EdgeDriver();

        try {
            // Set an implicit wait time for locating elements
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to the page
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

            // Task 1: Locate and validate buttons
            WebElement addBoxButton = driver.findElement(By.id("adder")); // Locate the "Add Box" button
            WebElement revealInputButton = driver.findElement(By.id("reveal")); // Locate the "Reveal Input" button

            // Check if both buttons are displayed on the page
            if (addBoxButton.isDisplayed() && revealInputButton.isDisplayed()) {
                System.out.println("***Task1*** addBoxButton and revealInputButton buttons are displayed successfully.");
            }

            // Task 2: Explicit Wait for a new box
            addBoxButton.click();           // Click on the "Add Box" button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement newBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='box']")));

            // Verify that the newly added box is displayed
            if (newBox.isDisplayed()) {
                System.out.println("***Task2*** New box is visible.");
            }

            // Task 3: Explicit Wait for revealed input
            revealInputButton.click(); // Click on the "Reveal a new input" button
            WebElement revealedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed"))); // Wait until the input field with ID "revealed" becomes visible and assign it to revealedInput


            // Verify that the input field is displayed
            if (revealedInput.isDisplayed()) {
                System.out.println("***Task3*** Input field is revealed.");
            }


            // Task 4: Input text and validate
            String inputText = "Selenium Wait Test"; // Define the text to be input
            revealedInput.sendKeys("Selenium Wait Test"); // Enter the text into the input field

            // Check if the entered text matches the expected value
            if (revealedInput.getDomProperty("value").equals(inputText)) {
                System.out.println("***Task4*** Text is entered successfully.");
            } else {
                System.out.println("Text is not entered");
            }


            // Task 5: Add multiple boxes and count
            List<WebElement> initialboxes = driver.findElements(By.cssSelector(".redbox")); // Locate all existing boxes
            int initialBoxCount = initialboxes.size(); // Count the initial number of boxes

            System.out.println("***Task5*** Initial number of boxes: " + initialBoxCount);

            int boxesToAdd = 5; // Define how many boxes to add
            for (int i = 0; i < boxesToAdd; i++) {
                addBoxButton.click(); // Click to add more boxes
            }

          /*  // Use a FluentWait to wait until the total number of boxes is updated
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10)) // Set the maximum wait time
                    .pollingEvery(Duration.ofMillis(500)) // Set the polling interval
                    .ignoring(NoSuchElementException.class); // Ignore exceptions during polling

            // Wait until the total number of boxes matches the expected count
            fluentWait.until(driver1 -> driver.findElements(By.className("redbox")).size() == initialBoxCount + boxesToAdd);
            // The FluentWait lambda function uses `driver1` as its parameter, representing the WebDriver instance provided during polling.
            // However, the code also uses `driver`, which is the original WebDriver instance created earlier in the method.
            // Both `driver` and `driver1` refer to the same WebDriver instance, so there is no functional difference here.
            // For clarity and best practices, it's recommended to use the lambda parameter `driver1` consistently inside the lambda expression.
            // Example of cleaner usage: fluentWait.until(driver1 -> driver1.findElements(By.className("redbox")).size() == initialBoxCount + boxesToAdd);


            List<WebElement> numOfBoxes = driver.findElements(By.className("redbox")); // Locate all the boxes again to verify the updated count
            System.out.println("***Task5*** Total number of boxes: " + numOfBoxes.size()); // Print the total number of boxes after the operation
*/
/*
            //Second way, this approach demonstrates another way to use FluentWait.

            // Create a FluentWait instance with the WebDriver
            Wait<WebDriver> waitUntilAllBoxesAreVisible = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))  // Set the maximum wait time to 10 seconds
                    .pollingEvery(Duration.ofSeconds(1)) // Poll for the condition every 1 second
                    .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException during polling

            // Wait until the total number of boxes matches the expected count
            waitUntilAllBoxesAreVisible.until(driver2->driver2.findElements(By.className("redbox")).size()==initialBoxCount+boxesToAdd);*/
            List<WebElement> numOfBoxes = driver.findElements(By.className("redbox")); // Locate all the boxes again to verify the updated count

            System.out.println("***Task5*** Total number of boxes: " + numOfBoxes.size()); // Print the total number of boxes after the operation


        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}


