// Specify the package name for the class
package lesson1;

// Import the WebDriver interface from the Selenium library
import org.openqa.selenium.WebDriver;
// Import the ChromeDriver class from the Selenium library
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

// Define the public class named "Lesson1"
public class Lesson1 {
    // The main method serves as the entry point for the Java application
    public static void main(String[] args) {
        // Create an instance of the ChromeDriver class to initialize the Chrome browser
        WebDriver driver = new ChromeDriver();
        WebDriver driver2 = new EdgeDriver();

        // Use the driver instance to open the specified URL in the browser
        driver.get("https://www.google.com/");
    }
}


