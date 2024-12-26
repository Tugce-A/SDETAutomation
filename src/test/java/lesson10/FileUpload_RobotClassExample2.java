package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class FileUpload_RobotClassExample2 {
    public static void main(String[] args) throws AWTException {
        fileUpload();
    }

    public static void fileUpload() throws AWTException {
        // Initialize the Firefox WebDriver
        WebDriver driver = new FirefoxDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set a timeout for page load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        // Navigate to the target URL
        driver.get("https://www.grammarly.com/plagiarism-checker");

        // Set an implicit wait for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Perform a scroll operation using JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)"); // Scroll down by 200 pixels

        // Wait until the "Upload a file" button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement browse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Upload a file']")));

        // Click the "Upload a file" button
        browse.click();

        // Create an instance of the Robot class
        Robot robot = new Robot();

        // Add a small delay to ensure the file dialog appears
        robot.delay(1000);

        // Copy the file path to the system clipboard
        StringSelection str = new StringSelection("C:\\Users\\barisa\\IdeaProjects\\SDETAutomation\\src\\test\\java\\lesson10\\file-sample_1MB.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // Simulate pressing "Control + V" to paste the file path into the dialog
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // Release "Control + V" keys
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Simulate pressing "Enter" to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        // Print a message to confirm the test execution
        System.out.println("Test completed successfully");

        // Uncomment the line below to close the browser after the test
        // driver.quit();
    }
}
