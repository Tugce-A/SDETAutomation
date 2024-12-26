package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDown_Examples2 {

    public static void main(String[] args) {
        // Call Method 1: Select an option using a List and iteration
        selectOptionUsingList();

        // Call Method 2: Select an option using a Custom Locator
        selectOptionUsingCustomLocator();

        // Call Method 3: Select an option using JavaScriptExecutor
        selectOptionUsingJavaScriptExecutor();

        // Call Method 4: Select an option using SendKeys
        selectOptionUsingSendKeys();
    }

    // Method 1: By storing all the options in a List and iterating through it
    public static void selectOptionUsingList() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the target webpage
        driver.get("https://www.bstackdemo.com/");

        // Click on the dropdown to expand the options
        driver.findElement(By.xpath("//select")).click();

        // Find all options inside the dropdown using CSS Selector
        List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));

        // Define the option to select
        String option = "Highest to lowest";

        // Iterate through the options list and select the desired option
        for (int i = 0; i < allOptions.size(); i++) {
            if (allOptions.get(i).getText().contains(option)) {
                allOptions.get(i).click();
                System.out.println("Method 1: Option clicked using List iteration");
                break;
            }
        }

        // Close the browser
        //driver.quit();
    }

    // Method 2: By creating a Custom Locator and selecting the option directly
    public static void selectOptionUsingCustomLocator() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the target webpage
        driver.get("https://www.bstackdemo.com/");

        // Click on the dropdown to expand the options
        driver.findElement(By.xpath("//select")).click();

        // Define the option text to locate
        String option = "Highest to lowest";

        // Find the specific option directly using XPath
        WebElement dropdown = driver.findElement(By.xpath("//select/option[contains(text(), '" + option + "')]"));

        // Click the desired option
        dropdown.click();

        System.out.println("Method 2: Option clicked using Custom Locator");

        // Close the browser
        //driver.quit();
    }

    // Method 3: By using JavaScriptExecutor to select the option
    public static void selectOptionUsingJavaScriptExecutor() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the target webpage
        driver.get("https://www.bstackdemo.com/");

        // Locate the dropdown element
        WebElement dropDown = driver.findElement(By.xpath("//select"));

        // Use JavaScriptExecutor to set the dropdown value
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='highestprice'", dropDown);

        System.out.println("Method 3: Option clicked using JavaScriptExecutor");

        // Close the browser
        //driver.quit();
    }

    // Method 4: By using SendKeys to select the option
    public static void selectOptionUsingSendKeys() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the target webpage
        driver.get("https://www.bstackdemo.com/");

        // Use SendKeys to set the dropdown value
        driver.findElement(By.xpath("//select")).sendKeys("highestprice");

        System.out.println("Method 4: Option selected using SendKeys");

        // Close the browser
        //driver.quit();
    }
}
