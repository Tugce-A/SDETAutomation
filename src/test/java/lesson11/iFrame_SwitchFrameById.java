package lesson11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class iFrame_SwitchFrameById {
    public static void main(String[] args) {
        // Call the method to switch to an iframe by its ID
        frameByID();
    }

    public static void frameByID() {
        // Instantiate the EdgeDriver to launch the Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the web page that contains the iframe
        driver.get("https://demoqa.com/frames");

        // Switch the WebDriver's context to the iframe using its ID
        driver.switchTo().frame("frame1");

        // Best practice: Add driver.quit() to close the browser after execution
        //driver.quit();
    }
}
