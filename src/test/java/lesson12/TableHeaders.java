package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableHeaders {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Open the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

        // Locate the table element
        WebElement table1 = driver.findElement
                (By.xpath ("/html/body/main/div/div/div[2]/form/div[2]/table"));

        // Find all rows in the table
        List<WebElement> r = table1.findElements(By.xpath(".//tr"));

        // Looping through rows and get headers
        for (WebElement rw : r) {
            List<WebElement> cell = rw.findElements(By.xpath(".//th"));
            for (WebElement c : cell) {
                String value = c.getText();
                System.out.println("Table headers: " + value);
            }
        }

        // Closing browser
        //driver.quit();
    }
}
