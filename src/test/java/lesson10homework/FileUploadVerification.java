package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileUploadVerification {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the file upload page
        String url = "https://testpages.herokuapp.com/styled/file-upload-test.html";
        driver.get(url);

        // Set up an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // File to upload
            File fileToUpload = new File("src/test/java/lesson10homework/testfile.txt");
            if (!fileToUpload.exists()) {
                throw new RuntimeException("File does not exist: " + fileToUpload.getAbsolutePath());
            }

            // Upload the file
            WebElement fileInput = driver.findElement(By.id("fileinput"));
            fileInput.sendKeys(fileToUpload.getAbsolutePath());

            // Click the upload button
            WebElement uploadButton = driver.findElement(By.xpath("//input[@type='submit']"));
            uploadButton.click();

            // Validate the success message
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(text(),'You uploaded a file. This is the result.')]")));

            if (successMessage.isDisplayed()) {
                System.out.println("Success message displayed: " + successMessage.getText());
            } else {
                System.out.println("Success message not displayed. Test failed.");
            }

            // File size
            String fileName = "src/test/java/lesson10homework/testfile.txt";
            File f = new File(fileName);
            long fileSize = f.length();
            System.out.format("The size of the file: %d bytes", fileSize);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //  driver.quit();
        }
    }
}
