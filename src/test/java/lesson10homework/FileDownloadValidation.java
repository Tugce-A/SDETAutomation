package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;

public class FileDownloadValidation {
    public static void main(String[] args) {

        // Configure ChromeOptions to set the default download directory
        String downloadDir = System.getProperty("user.home") + "/Downloads";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // Set the default directory for downloads
        //options.addArguments("disable-popup-blocking");
        //options.addArguments("--headless=new"); // Optional: Run in headless mode
        options.addArguments("download.default_directory=" + downloadDir);

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Navigate to the CSV sample page
            String url = "https://people.sc.fsu.edu/~jburkardt/data/csv/csv.html";
            driver.get(url);

            // Locate and click the download link for airtravel.csv
            WebElement csvLink = driver.findElement(By.xpath("//a[text()='airtravel.csv']"));
            csvLink.click();

            // Wait for the file to download (allow some time based on file size)
            Thread.sleep(5000); // Explicit wait to ensure download completes

            // Verify the file's presence in the download directory
            File downloadedFile = new File(downloadDir + "/airtravel.csv");
            if (downloadedFile.exists()) {
                System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
            } else {
                System.out.println("File download failed.");
                return;
            }

            BufferedReader reader = null;
            // Open the downloaded file for reading
            File file = new File(downloadedFile.getAbsolutePath());
            reader = new BufferedReader(new FileReader(file));
            // Read and print each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            // driver.quit();
        }
    }
}