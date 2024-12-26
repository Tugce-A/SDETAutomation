package lesson9;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RadioButtonExampleDemoQA {
    public static void main(String[] args) {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Opening the webpage where we will identify radio button
        driver.get("https://demoqa.com/radio-button");

        // Locate all radio button elements using XPath and store them in a list
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[contains(@class,'custom-control')]"));

        // Print the total number of radio buttons found
        System.out.println(radioButtons.size());

        // Iterate through the list of radio buttons and print their text (labels)
        for (WebElement radioButton : radioButtons) {
            System.out.println(radioButton.getText());
        }

        // Initialize an explicit wait with a timeout of 15 seconds
        //WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //WebElement radio1 = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'custom-control')])[1]/input")));
        //WebElement radio1 = driver.findElement(By.xpath("(//div[contains(@class,'custom-control')])[1]/input"));
        //WebElement radio1 = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Yes')]")));
        WebElement radio1_2 = driver.findElement(By.id("yesRadio"));
        WebElement radio1 = driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
        //radio1.click();

        // Check if the "Yes" radio button is enabled and print the result
        if (!radio1.isEnabled()) {
            System.out.println("Radio1 button cannot be clickable");
        } else {
            System.out.println("Radio1 button can be clickable");
        }


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio1);

        // Locate radio button 3, the "No" option, using its label text and ID
        WebElement radio3 = driver.findElement(By.xpath("//label[contains(text(),'No')]"));
        WebElement radio3_2 = driver.findElement(By.id("noRadio"));

        // Check if the "No" radio button is enabled and handle accordingly


        try {
            if (!radio3_2.isEnabled()) {
                System.out.println("'No' radio button is not clickable.");
                Object result = ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio3_2);
                System.out.println("JavaScript sonucu: " + result);
                //((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio3_2);
            }
            else {
                System.out.println("'No' radio button is clickable.");

            }
        } catch (ElementNotInteractableException e) {
            throw new RuntimeException(e);
        }

        }

    }
