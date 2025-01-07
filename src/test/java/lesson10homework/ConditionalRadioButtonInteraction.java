package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionalRadioButtonInteraction {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://qbek.github.io/selenium-exercises/en/radio_buttons.html");

        // Set up explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // Locate the "Radio ZET" radio button under the "Polish radio stations" section
            WebElement radioZET = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='radiozet']")));

            // Select the "Radio ZET" radio button
            radioZET.click();

            // Validate that the "Radio ZET" radio button is selected
            if (radioZET.isSelected()) {
                System.out.println("Radio ZET is successfully selected.");
            } else {
                System.out.println("Radio ZET selection failed.");
            }

            // Locate and click the test button
            WebElement webPageLink = driver.findElement(By.linkText("Web page"));
            webPageLink.click();

            // Validate redirection to the correct page
            String currentURL = driver.getCurrentUrl();
            if (currentURL.equals("https://www.radiozet.pl/")) {
                System.out.println("Page is redirected to the Radio ZET page.");
            } else {
                System.out.println("Redirection failed. Current URL is: " + currentURL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser and end the session
            //driver.quit();
        }
    }
}
