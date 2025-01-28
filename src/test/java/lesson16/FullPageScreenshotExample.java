package lesson16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.page.Page;

import java.io.File;
import java.io.IOException;

public class FullPageScreenshotExample {
        public static void main(String[] args) {
            // Set up WebDriver
            ChromeDriver driver = new ChromeDriver();

            try {
                // Start DevTools session
                DevTools devTools = driver.getDevTools();
                devTools.createSession();

                // Enable the Page module for full-page screenshot
                devTools.send(Page.enable());

                // Navigate to a website
                driver.get("https://www.trendyol.com");

                // Capture a full-page screenshot
                File fullPageScreenshot = driver.getScreenshotAs(OutputType.FILE);

                // Save the screenshot to the specified location
                File destinationFile = new File("src/test/java/lesson16/fullpageTrendyolScreenshotWithDevtools.png");
                FileUtils.copyFile(fullPageScreenshot, destinationFile);

                System.out.println("Full page screenshot saved as: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the WebDriver
                //driver.quit();
            }
        }
}

