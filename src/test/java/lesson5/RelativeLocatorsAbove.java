package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsAbove {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // launching a browser and navigate to a URL
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // identify first element
        WebElement l = driver.findElement(By.xpath("//*[@id='collapseTwo']/div/ul/li[2]/a"));

        // identify element above the first element
        WebElement e = driver.findElement(RelativeLocator.with(By.tagName("a")).above(l));

        // Getting element text value the above identified element
        System.out.println("Getting element text: " + e.getText());

        // Closing browser
        //driver.quit();
    }
}
