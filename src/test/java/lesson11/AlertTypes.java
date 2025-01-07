package lesson11;

import org.openqa.selenium.By; // Used to locate elements on the web page
import org.openqa.selenium.JavascriptExecutor; // Used to execute JavaScript within the browser
import org.openqa.selenium.WebDriver; // WebDriver interface to control the browser
import org.openqa.selenium.WebElement; // Represents elements on the web page
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver implementation for controlling the Chrome browser

public class AlertTypes {

    public static void main(String[] args) {
        // Method to handle a simple alert and print its text
        //getAlertText();

        // Method to handle a prompt box alert, send input, and print the result
        //promptBoxAlert();

        // Method to handle a confirm box and accept it
        confirmBoxAccept();

        // Method to handle a confirm box and cancel it
        //confirmBoxCancel();
    }

    public static void getAlertText() {
        // Instantiate the ChromeDriver to launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the page containing alert examples
        driver.get("https://demoqa.com/alerts");

        // Locate the "Click Me" button that triggers the alert
        WebElement clickMeButton = driver.findElement(By.id("alertButton"));

        try {
            // Wait for 5 seconds (simulating explicit wait; replace with WebDriverWait for best practice)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click the button to trigger the alert
        clickMeButton.click();

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text to the console
    }

    public static void promptBoxAlert() {
        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the page containing the prompt box example
        driver.get("https://demoqa.com/alerts");

        // Locate the button that triggers the prompt box
        WebElement promptButton = driver.findElement(By.id("promtButton"));

        // Use JavaScript to click the button because a direct click may cause an interception error
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", promptButton);

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text

        // Send text input to the prompt box
        driver.switchTo().alert().sendKeys("Baris");

        try {
            // Wait for 3 seconds to simulate a pause
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Accept the prompt box
        driver.switchTo().alert().accept();

        // Locate and retrieve the result of the prompt box interaction
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        System.out.println("Prompt result: " + promptResult.getText()); // Print the result
    }

    public static void confirmBoxAccept() {
        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the page containing the confirm box example
        driver.get("https://demoqa.com/alerts");

        // Locate the button that triggers the confirm box
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));

        // Use JavaScript to click the button because a direct click may cause an interception error
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", confirmButton);

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text

        try {
            // Wait for 3 seconds to simulate a pause
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Accept the confirm box
        driver.switchTo().alert().accept();
    }

    public static void confirmBoxCancel() {
        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the page containing the confirm box example
        driver.get("https://demoqa.com/alerts");

        // Locate the button that triggers the confirm box
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));

        // Use JavaScript to click the button because a direct click may cause an interception error
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", confirmButton);

        // Switch to the alert and retrieve its text
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText); // Print the alert text

        try {
            // Wait for 3 seconds to simulate a pause
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Dismiss (cancel) the confirm box
        driver.switchTo().alert().dismiss();
    }
}
