package lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CheckboxExampleTutorialsPoint {
    public static void main(String[] args) throws InterruptedException {
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Opening the webpage where we will identify radio button
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // Retrieve all checkboxes using locator and storing in List
        List<WebElement> totalCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        // count number of checkboxes
        int countOfCheckboxes = totalCheckboxes.size();
        System.out.println("Count the checkboxes: " + countOfCheckboxes);


        // identify the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='hobbies']"));

        // verify if checkbox1 is not selected
        boolean checkbox1isNotSelected = checkbox1.isSelected();
        System.out.println("Checking if a checkbox 1 is not selected: " + checkbox1isNotSelected);

        //hard sleep 5 seconds
        Thread.sleep(5000);

        //click checkbox 1
        checkbox1.click();

        // verify if checkbox 1 is selected
        boolean checkbox1isSelected = checkbox1.isSelected();
        System.out.println("Checking whether checkbox 1 is selected after clicking the checkbox 1: " + checkbox1isSelected);

        // verify if checkbox 1 is displayed
        boolean checkbox1isDisplayed = checkbox1.isDisplayed();
        System.out.println("Checking if a checkbox 1 is displayed: " + checkbox1isDisplayed);

        // verify if checkbox 1 is enabled
        boolean checkbox1isEnabled = checkbox1.isEnabled();
        System.out.println("Checking if a checkbox 1 is enabled: " + checkbox1isEnabled);


        // Iterate over the list of checkbox names
        List<WebElement> nameListOfCheckboxes = driver.findElements(By.xpath("//label[@class='col-form-label']"));
        for (WebElement checkboxName : nameListOfCheckboxes) {
            for (WebElement checkbox : totalCheckboxes) {     // Iterate over all checkboxes and click on those that are not selected
                if (!checkbox.isSelected()) {
                    checkbox.click(); // Click the checkbox if not already selected
                    System.out.println("Non selected checkboxes were selected");
                }
            }
            // Print the name of the current checkbox
            System.out.println("Checkbox name is: " + checkboxName.getText());
        }


        // Closing browser
        //driver.quit();
    }
}
