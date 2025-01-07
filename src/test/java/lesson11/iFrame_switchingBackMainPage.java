package lesson11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// This class demonstrates how to switch to an iframe and then return to the main page
public class iFrame_switchingBackMainPage {

    public static void main(String[] args) {
        // Call the method to switch to an iframe and then back to the main page
        switchingBackMainPage();
    }

    public static void switchingBackMainPage() {
        // Instantiate the ChromeDriver to launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page containing iframes
        driver.get("https://demoqa.com/frames");

        // Switch the WebDriver's context to the first iframe using its index (0-based indexing)
        driver.switchTo().frame(0);

        // Switch the WebDriver's context back to the main (parent) page
        driver.switchTo().defaultContent();

        // Close the browser after execution to release resources
        //driver.quit();
    }
}

