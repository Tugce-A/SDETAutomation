package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsChain {
    public static void main(String[] args) {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // launching a browser and navigate to a URL
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // identify first element
        WebElement l = driver.findElement(By.xpath("//*[@id='practiceForm']/div[1]/label"));

        // identify second element
        WebElement s = driver.findElement(By.xpath("//*[@id='practiceForm']/div[2]/label"));

        // identify element by chaining elements
        WebElement e = driver.findElement(RelativeLocator.with(By.tagName("input")).above(s).toRightOf(l));

        // input text
        e.sendKeys("Selenium");

        // verify is selected
        System.out.println("Value entered is: " + e.getAttribute("value"));

        // Closing browser
        //driver.quit();
    }
}
