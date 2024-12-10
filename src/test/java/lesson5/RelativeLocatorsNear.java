package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsNear {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // launching a browser and navigate to a URL
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // identify first element
        WebElement l = driver.findElement(By.xpath("//*[@id='practiceForm']/div[7]/div/div/div[1]/label"));

        // identify element near the first element
        WebElement e = driver.findElement(RelativeLocator.with(By.tagName("input")).near(l));

        // check checkbox
        e.click();

        // verify is selected
        System.out.println("Verify if selected: " + e.isSelected());

        // Closing browser
        //driver.quit();
    }
}
