package lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RadioButtonExampleTutorialsPoint {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Opening the webpage where we will identify radio button
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // Retrieve all radio buttons using locator and storing in List
        List<WebElement> totalRadioBtns = driver.findElements(By.xpath("//input[@type='radio']"));

        // count number of radio buttons
        int count = totalRadioBtns.size();
        System.out.println("Count the radio buttons: " + count);

        // identify radio button 1
        WebElement radiobtn1 = driver.findElement(By.xpath("//*[@id='gender']"));

        // verify if radio button 1 is not selected
        boolean checkRadioButton1isNotSelected = radiobtn1.isSelected();
        System.out.println("Checking if a radio button 1 is not selected: " + checkRadioButton1isNotSelected);

        //hard sleep 5 seconds
        Thread.sleep(5000);

        //click radio button 1
        radiobtn1.click();

        // verify if radio button 1 is selected
        boolean checkRadioButton1isSelected = radiobtn1.isSelected();
        System.out.println("Checking whether radio button 1 is selected after clicking the radio button 1: " + checkRadioButton1isSelected);

        // verify if radio button is displayed
        boolean checkRadioButton1isDisplayed = radiobtn1.isDisplayed();
        System.out.println("Checking if a radio button 1 is displayed: " + checkRadioButton1isDisplayed);

        // verify if radio button is enabled
        boolean checkRadioButton1isEnabled = radiobtn1.isEnabled();
        System.out.println("Checking if a radio button 1 is enabled: " + checkRadioButton1isEnabled);


        // Closing browser
        //driver.quit();
    }

    }
