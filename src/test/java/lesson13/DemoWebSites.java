package lesson13;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebSites {
    // Main method is commented out because it is not used in the test execution.
    /*   public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Initializes a new ChromeDriver instance
        driver.get("https://www.google.com"); // Navigates to Google's homepage
        driver.get("https://linkedin.com"); // Navigates to LinkedIn's homepage
    }*/

    static WebDriver driver; // Static WebDriver instance for all tests

    @BeforeAll
    public static void setup(){
        // This method runs once before all tests to initialize the WebDriver
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void maximizeBrowser(){
        // This method runs before each test to maximize the browser window
        driver.manage().window().maximize();
    }

    @org.junit.jupiter.api.Test
    public void GooglePage(){
        // This test navigates to Google's homepage and waits for 3 seconds
        driver.navigate().to("https://www.google.com");
        try {
            Thread.sleep(3000); // Pauses execution for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Throws a runtime exception in case of interruption
        }
    }

    @Test
    public void LinkedinPage(){
        // This test navigates to LinkedIn's homepage and waits for 5 seconds
        driver.get("https://linkedin.com");
        try {
            Thread.sleep(5000); // Pauses execution for 5 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Throws a runtime exception in case of interruption
        }
    }

    @AfterEach
    public void getTitle(){
        // This method runs after each test to retrieve and print the page title
        String PageTitle =  driver.getTitle(); // Gets the title of the current page
        System.out.println("Page title is " + PageTitle); // Prints the page title to the console
    }

    @Disabled("Tarayıcının kapanması yok sayıldı") // This test is disabled, explaining the browser closure is ignored
    public void tearDown(){
        // This method is intended to close the browser after tests (currently disabled)
        driver.quit();
    }
}
