package lesson12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HorizontalScrolls {
    public static void main(String[] args) {
        HorizontalScrollMethod();
    }
    public static void HorizontalScrollMethod(){

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage where we will perform horizontal scroll
        driver.get("https://www.tutorialspoint.com/selenium/practice/horizontal-scroll.php");

        // JavascriptExecutor to perform horizontal scroll by 20000, 0 pixels
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(20000,0)", "");
    }
}
