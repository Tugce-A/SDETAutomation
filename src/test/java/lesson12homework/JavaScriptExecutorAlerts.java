package lesson12homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorAlerts {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Handle JavaScript Alert
            WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
            jsAlertButton.click();

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            alert.accept();

            // Handle JavaScript Confirm
            WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            jsConfirmButton.click();

            alert = driver.switchTo().alert();
            String confirmText = alert.getText();
            System.out.println("Confirm Text: " + confirmText);
            alert.dismiss();

            // Handle JavaScript Prompt
            WebElement jsPromptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
            jsPromptButton.click();

            alert = driver.switchTo().alert();
            System.out.println("Prompt Text Before Input: " + alert.getText());
            String inputText = "Hello World";
            alert.sendKeys(inputText);
            alert.accept();

            // Verify result on the page
            WebElement result = driver.findElement(By.id("result"));
            if (result.getText().contains(inputText)) {
                System.out.println("Test Passed: Prompt result contains the input text.");
            } else {
                System.out.println("Test Failed: Prompt result does not contain the input text.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           // driver.quit();
        }
    }
}