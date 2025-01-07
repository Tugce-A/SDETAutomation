package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class Window_NewWindow {
    public static void main(String[] args) {
        // Method to handle and fetch the heading of a newly opened window
        NewWindow();
        // Method to retrieve and print the window handle of the current browser window
        getWindowHandle();
    }


    public static void NewWindow() {
        // Initialize the WebDriver (Chrome browser)
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Method to retrieve and print the window handle of the current browser window
        driver.get("https://demoqa.com/browser-windows");

        // Locate the button that opens a new child window
        WebElement windowButton = driver.findElement(By.id("windowButton"));

        // Use JavaScript Executor to click the button, ensuring no click interception issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", windowButton);

        // Store the main window's handle
        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles (main + child windows)
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Iterate through all window handles
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();

            // If the current window is not the main window, switch to it
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);

                // Locate the heading element in the child window and fetch its text
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is:  " + text.getText());

                // Close the child window (optional, depending on test requirements)
                //driver.close();
            }
        }
        // Switch back to the main window (optional, depending on further steps)
        driver.switchTo().window(mainWindowHandle);

        // Close the main browser session to free resources
        //driver.quit();
    }

    public static  void getWindowHandle(){
        // Initialize the WebDriver for Chrome browser
        WebDriver driver = new ChromeDriver();
        // Navigate to Google
        driver.get("https://www.google.com");

        // Print the unique window handle of the current browser window
        System.out.println(driver.getWindowHandle());

        // Close the browser session
        //driver.quit();
    }
}
