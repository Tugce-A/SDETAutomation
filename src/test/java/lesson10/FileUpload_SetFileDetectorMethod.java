package lesson10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FileUpload_SetFileDetectorMethod {

    // To Download Selenium Grid 4.27.0: https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.27.0/selenium-server-4.27.0.jar
    // 1. First of all, to start Selenium Grid, please run the following two commands on CMD in the directory where the "selenium-server-4.27.0.jar" file is located
    //java -jar selenium-server-4.27.0.jar hub
    //java -jar selenium-server-4.27.0.jar node --detect-drivers true

    // Then, please run fileUpload method after Selenium Grid Node and Hub are running.

    public static void main(String[] args) throws MalformedURLException {
        fileUpload();
    }
    public static void fileUpload() throws MalformedURLException {

                // Initialize ChromeOptions
                ChromeOptions options = new ChromeOptions();

                // Initialize RemoteWebDriver with the Selenium Grid hub URL and ChromeOptions
                RemoteWebDriver driver = new RemoteWebDriver(new URL(" http://192.168.1.111:4444/wd/hub"), options);

                // Set the File Detector for the RemoteWebDriver instance
                driver.setFileDetector(new LocalFileDetector());

                // Navigate to the file upload page
                driver.get("http://the-internet.herokuapp.com/upload");

                // Locate the file upload element by its ID
                WebElement uploadElement = driver.findElement(By.id("file-upload"));

                // Specify the path to the local file to be uploaded
                String filePath = "C:\\Users\\barisa\\IdeaProjects\\SDETAutomation\\src\\test\\java\\lesson10\\test_File.docx"; // Replace with the actual path to your file

                // Upload the file
                uploadElement.sendKeys(filePath);

                // Locate and click the upload button
                WebElement uploadButton = driver.findElement(By.id("file-submit"));
                uploadButton.click();

                // Additional steps after file upload (if any)
                // For example, verify the upload
                WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
                if (uploadedFile.getText().contains("test_File.docx")) {
                    System.out.println("File uploaded successfully!");
                } else {
                    System.out.println("File upload failed.");
                }

                // Quit the browser
               //driver.quit();

            }
        }

