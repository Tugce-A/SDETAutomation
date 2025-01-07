package lesson11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class AndGetCookie {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // open browser session
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // Add cookie in key-value pairs
        driver.manage().addCookie(new Cookie("C1", "VAL1"));

        // Get added cookie with name
        Cookie c1 = driver.manage().getCookieNamed("C1");
        System.out.println("Cookie details: " + c1);

        // Closing browser
        driver.quit();
    }
}