package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class PageDownScrolls {
    public static void main(String[] args) {
        PageDownScrollsMethod();
    }
    public static void PageDownScrollsMethod() {// Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Opening the webpage where we will perform the scroll down
        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");

        // JavascriptExecutor to scrolling to page bottom
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // access element at page bottom after scrolling
        String text = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/h3[4]")).getText();
        System.out.println("Get text at page bottom: " + text);

        WebElement lastParagraph = driver.findElement(By.xpath("//p[@class='text-justify'][11]"));
        String lastParagraphText = lastParagraph.getText();
        String expectedText = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

        if (!lastParagraphText.equals(expectedText)) {
            throw new AssertionError("Assertion failed: Texts do not match.\nExpected: " + expectedText + "\nActual: " + lastParagraphText);
        }

        System.out.println("Texts match successfully.");

        // quitting the browser
        //driver.quit();
    }
}