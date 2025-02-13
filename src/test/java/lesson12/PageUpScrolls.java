package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageUpScrolls {
    public static void main(String[] args) {
        PageUpScrollsMethod();
    }
    public static void PageUpScrollsMethod() {// Initiate the Webdriver
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage where we will perform the scrolling
        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");

        // JavascriptExecutor to scrolling to page bottom
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // access element at page bottom after scrolling
        String text = driver.findElement
                (By.xpath("/html/body/main/div/div/div[2]/h3[4]")).getText();
        System.out.println("Get the text at page bottom: " + text);

        //driver.navigate().refresh();
        //driver.navigate().back();
        // JavascriptExecutor to scrolling to page top
        javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        // access element at page top after scrolling
        String text1 = driver.findElement
                (By.xpath("/html/body/div/header/div[2]/h1")).getText();
        System.out.println("Get the text at page top: " + text1);

        // quitting the browser
        //driver.quit();
    }
}