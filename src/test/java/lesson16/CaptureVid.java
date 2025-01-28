package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CaptureVid {
    public static void main(String[] args) throws Exception {

        // start screen recording
        CaptureVidUtil.startRecord("main");

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage where we will identify checkbox
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");

        // Identify element then click
        WebElement c = driver.findElement(By.xpath("//*[@id='c_bs_1']"));
        c.click();

        // verify if checkbox is selected
        Boolean result = c.isSelected();
        System.out.println("Checkbox is selected: " + result);

        //Closing browser
        driver.quit();

        // stop recording
        CaptureVidUtil.stopRecord();
    }
}
