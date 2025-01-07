package lesson11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// This class demonstrates switching to an iframe using its index
public class iFrame_SwitchFrameByIndex {
    public static void main(String[] args) {
        // Call the method to switch to an iframe by its index
        frameByIndex();
    }

    public static void frameByIndex() {
        // Instantiate the EdgeDriver to launch the Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the web page containing iframes
        driver.get("https://demoqa.com/frames");

        // Switch the WebDriver's context to the first iframe using its index (0-based indexing)
        driver.switchTo().frame(8);

        // Best practice: Add driver.quit() to close the browser after execution
        //driver.quit();
    }
}

