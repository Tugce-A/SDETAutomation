package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesInteraction {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate and sort the table by "Name" column
            WebElement nameHeader = driver.findElement(By.xpath("(//span[text()='Name'])[1]"));
            nameHeader.click();

            // Wait for sorting to complete (basic wait for demo purposes)
            Thread.sleep(2000);

            // Retrieve the first 5 rows of the "Name" column
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));

            System.out.println("First 5 names in the sorted column:");
            for (int i = 0; i < Math.min(5, rows.size()); i++) {
                System.out.println((i + 1) + ". " + rows.get(i).getText());
            }

            // Perform a search for "Software Engineer"
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
            searchBox.sendKeys("Software Engineer");

            // Wait for the search results to update
            Thread.sleep(2000);

            // Validate the search results
            List<WebElement> searchResults = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));

            if (!searchResults.isEmpty()) {
                System.out.println("Search results found: " + searchResults.size() + " rows.");
                for (WebElement row : searchResults) {
                    System.out.println(row.getText());
                }
            } else {
                System.out.println("No search results found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           // driver.quit();
        }
    }
}
