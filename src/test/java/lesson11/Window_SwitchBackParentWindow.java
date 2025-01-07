package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Window_SwitchBackParentWindow {
    public static void main(String[] args) {
        // Call the method to demonstrate switching back to the parent window
        switchBack();
    }

    public static void switchBack() {
        // Initialize WebDriver for Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window

        // Navigate to the target URL
        driver.get("https://demoqa.com/browser-windows");

        // Locate and click the button that opens a new child window
        WebElement windowButton = driver.findElement(By.id("windowButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", windowButton); // Use JavaScript to click the button

        // Store the handle of the main (parent) window
        String mainwindow = driver.getWindowHandle();

        // Get handles of all open windows (parent + child windows)
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        // Iterate through all window handles
        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            // If the current window is not the parent window, switch to it
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow); // Switch to the child window

                // Locate the heading element in the child window and print its text
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());

                // Close the child window
                driver.close();
                System.out.println("Child window closed");
            }
        }

        // Switch back to the main window (parent window) after closing the child window
        driver.switchTo().window(mainwindow);
        System.out.println("Switched back to the parent window");

        // Optional: Close the browser (currently commented for demonstration purposes)
        // driver.quit();
    }
}