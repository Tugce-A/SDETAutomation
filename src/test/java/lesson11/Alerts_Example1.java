package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts_Example1 {
    public static void main(String[] args) {
        // Call the method to demonstrate handling a simple alert
        simpleAlert();
    }
    public static void simpleAlert() {
        // Instantiate a ChromeDriver to launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to the URL with alert examples
        driver.get("https://demoqa.com/alerts");
        // Initialize WebDriverWait to wait up to 10 seconds for a condition to be met
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the alert button is visible, then click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertButton"))).click();
        // Switch to the alert and accept it
        driver.switchTo().alert().accept();
    }
}
