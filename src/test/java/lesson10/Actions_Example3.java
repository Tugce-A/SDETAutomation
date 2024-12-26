package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Actions_Example3 {

    public static void main(String[] args) throws InterruptedException {
        //instantiate the driver
        WebDriver driver = new ChromeDriver();
        //specify the URL of the webpage
        driver.get("https://www.amazon.in/");
        //maximise the window
        driver.manage().window().maximize();
        //create an object for the Actions class and pass the driver argument
        Actions action = new Actions(driver);
        //specify the locator of the search box in which the product has to be typed
        WebElement elementToType = driver.findElement(By.id("twotabsearchtextbox"));
        //pass the value of the product
        action.sendKeys(elementToType, "iphone").build().perform();
        //specify the locator of the search button
        WebElement elementToClick = driver.findElement(By.id("nav-search-submit-button"));
        //perform a mouse click on the search button
        action.click(elementToClick).build().perform();

        // Use WebDriverWait to ensure the search results page loads
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("iphone"));

        //verify the title of the website after searching for the product
        String expectedTitle = "Amazon.in : iphone";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is incorrect.");
        }

        // Close the browser and quit the driver
        // driver.quit();
    }


}
