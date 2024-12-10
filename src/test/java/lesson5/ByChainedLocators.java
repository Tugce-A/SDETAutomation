package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ByChainedLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Example: Find the "Add Element" button inside the page's content container
        WebElement addButton = driver.findElement(
                new ByChained(
                        By.tagName("div"),  // First, locate the main container
                        By.tagName("button") // Then locate the button inside it
                )
        );

        addButton.click(); // Click to add a "Delete" button
        //driver.quit();
    }
}