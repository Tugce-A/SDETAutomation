package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingWebTable {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Open the webpage to identify table
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

        // Locate the table element
        WebElement table1 = driver.findElement
                (By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table"));

        // Find all rows in the table
        List<WebElement> r = table1.findElements(By.xpath(".//tr"));

        // Looping through rows and get cell values
        for (WebElement rw : r) {
            List<WebElement> cell = rw.findElements(By.xpath(".//td"));
            for (WebElement c : cell) {
                String value = c.getText();
                System.out.println("Cells values: " + value);
            }
        }

        // Closing browser
      // driver.quit();
    }
}