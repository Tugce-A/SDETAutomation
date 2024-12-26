package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUpload_SendKeysMethod {
    public static void main(String[] args) {
        FileUploadTest();
    }

    public static void FileUploadTest() {
        // Initialize the Edge WebDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the target file upload URL
        driver.get("https://the-internet.herokuapp.com/upload");

        // Create an explicit wait instance for synchronization
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the file upload input field is present
        WebElement chooseFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='file-upload']")));

        // Provide the file path to the upload input field using sendKeys
        chooseFile.sendKeys("C:\\Users\\barisa\\IdeaProjects\\SDETAutomation\\src\\test\\java\\lesson10\\test_File.docx");

        // Wait until the upload button is clickable and then click it
        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("file-submit")));
        uploadButton.click();

        // Wait until the upload confirmation message is visible
        WebElement fileUploadTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));

        // Print a success message to the console
        if (fileUploadTest.isDisplayed()) {
            System.out.println("File uploaded successfully: " + fileUploadTest.getText());
        } else {
            System.out.println("File upload failed.");
        }

        // Close the browser (uncomment in production)
        // driver.quit();
    }
}
