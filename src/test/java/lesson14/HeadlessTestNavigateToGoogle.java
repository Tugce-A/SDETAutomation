package lesson14;

// Import necessary Selenium libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessTestNavigateToGoogle {

    // Test method to navigate to Google's homepage in headless mode
    @Test
    public void setup() throws InterruptedException {

        // Create a ChromeOptions object to configure Chrome browser settings
        ChromeOptions options = new ChromeOptions();

        // Add headless mode argument to run the browser without a graphical user interface (GUI)
        options.addArguments("--headless");

        // Initialize the WebDriver with the configured ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Navigate to Google's homepage
        driver.get("https://google.com/");
    }
}
