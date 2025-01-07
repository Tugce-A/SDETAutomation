package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicCheckboxInteraction {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait to handle element loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Navigate to the URL
            driver.get("https://artoftesting.com/samplesiteforselenium");

            // Locate all checkboxes under the "Checkbox :" section
            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

            // Verify the initial state of each checkbox and print it
            System.out.println("Initial states of checkboxes:");
        /*    for (int i = 0; i < checkboxes.size(); i++) {
                WebElement checkbox = checkboxes.get(i);
                boolean isChecked = checkbox.isSelected();
                System.out.println("Checkbox " + (i + 1) + ": " + (isChecked ? "Checked" : "Unchecked"));

                // Toggle the checkbox state
                checkbox.click();
            }*/
            int index = 1; // A counter for the checkbox number
            for (WebElement checkbox : checkboxes) {
                boolean isChecked = checkbox.isSelected();
                System.out.println("Checkbox " + index + ": " + (isChecked ? "Checked" : "Unchecked"));

                // Toggle the checkbox state
                checkbox.click();

                index++;
            }

            // Verify the final state of each checkbox and print it
            System.out.println("\nFinal states of checkboxes:");
            for (int i = 0; i < checkboxes.size(); i++) {
                WebElement checkbox = checkboxes.get(i);
                boolean isChecked = checkbox.isSelected();
                System.out.println("Checkbox " + (i + 1) + ": " + (isChecked ? "Checked" : "Unchecked"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            // driver.quit();
        }

    }

}
