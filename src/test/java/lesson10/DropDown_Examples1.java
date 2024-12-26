package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown_Examples1 {
    public static void main(String[] args) {
        // Call the method to select a country from a dropdown
        //selectCountry();

        // Call the method to select a fruit from a dropdown
        selectFruit();
    }

    public static void selectCountry() {
        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the URL for the registration page
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        // Locate the dropdown element for selecting a country
        WebElement country = driver.findElement(By.name("country"));

        // Use the Select class to interact with the dropdown
        Select dropCountry = new Select(country);

        // Select a country by visible text
        dropCountry.selectByVisibleText("TURKEY");

        // Close the browser (commented out to keep the browser open for testing)
        // driver.quit();
    }

    public static void selectFruit() {
        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the URL for the dropdown test page
        driver.get("http://output.jsbin.com/osebed/2");

        // Locate the dropdown element for selecting fruits
        WebElement fruits = driver.findElement(By.id("fruits"));

        // Use the Select class to interact with the dropdown
        Select dropFruits = new Select(fruits);

        // Select a fruit by its index in the dropdown (e.g., third option)
        dropFruits.selectByIndex(2);

        /*
         * Uncomment the following lines to select fruits by their visible text:
         * dropFruits.selectByVisibleText("Grape");
         * dropFruits.selectByVisibleText("Orange");
         * dropFruits.selectByVisibleText("Apple");
         */

        // Deselect all selected options in a multi-select dropdown (commented out)
        // dropFruits.deselectAll();

        // Close the browser (commented out to keep the browser open for testing)
        // driver.quit();
    }
}
