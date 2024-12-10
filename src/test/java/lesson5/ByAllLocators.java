package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.util.List;

public class ByAllLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Example: Find all "button" elements (both "Add Element" and dynamically added "Delete" buttons)
        List<WebElement> buttons = driver.findElements(
                new ByAll(
                        By.tagName("button")// Finds both the Add and Delete buttons
                )
        );
        System.out.println("buton sayisi:" +buttons.size());

        for (WebElement button : buttons) {
            System.out.println("Button Text: " + button.getText());
        }

       // driver.quit();
    }
}
