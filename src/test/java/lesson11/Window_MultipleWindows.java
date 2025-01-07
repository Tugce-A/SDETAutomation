package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Window_MultipleWindows {
    public static void main(String[] args) {
        // Method to handle multiple browser windows
        multipleWindows();
    }

    public static void multipleWindows() {
        // Initialize the WebDriver (Chrome browser)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the web page that opens multiple windows
        driver.get("https://demoqa.com/browser-windows");

        // Locate and click the button to open a new child window
        WebElement windowButton = driver.findElement(By.id("windowButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", windowButton);

        // Store the main window handle
        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // Get all window handles (main window + child windows)
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        // Iterate through all window handles
        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            // If the current window handle is not the main window, switch to it
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow); // Switch to the child window
                // Close the child window
                driver.close();
                System.out.println("Child window closed");
            }
        }
        // Switch back to the main window after closing all child windows
        driver.switchTo().window(MainWindow);
        System.out.println("Switched back to the main window");

        // Close the main window and terminate the browser session
        //driver.quit();
    }
}
