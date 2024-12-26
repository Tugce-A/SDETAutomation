package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class FileUpload_RobotClass {

    public static void main(String[] args) throws AWTException, InterruptedException {
        // Initialize the WebDriver (ChromeDriver instance)
        WebDriver driver = new ChromeDriver();

        // Navigate to the target URL
        driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");

        // Set an implicit wait to handle element loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Create an explicit wait to handle synchronization for specific elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait until the "Add files" button is clickable, then click it
        WebElement addFilesButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.fileinput-button")));
        addFilesButton.click();

        // Create a Robot class object to simulate keyboard actions
        Robot robot = new Robot();

        // Add a small delay to ensure the file dialog appears
        robot.delay(1000);

        // Store the file path in the system clipboard using StringSelection class
        StringSelection filepath = new StringSelection("C:\\Users\\barisa\\IdeaProjects\\SDETAutomation\\src\\test\\java\\lesson10\\Sample-png-image-100kb.png");

        // Copy the file path to the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

        // Simulate pressing "Ctrl + V" to paste the file path into the dialog
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // Release the "Ctrl" and "V" keys after the paste action
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Simulate pressing "Enter" to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Add a delay to allow the file to upload
        robot.delay(2000);

        // Log a message to indicate the file upload process was successful
        System.out.println("File Uploaded Successfully");

        // Uncomment the following line in production to close the browser after execution
        // driver.close();

    }
}
