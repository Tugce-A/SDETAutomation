package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimePickersCurrent {
    public static void main(String[] args) throws InterruptedException {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // URL launch for accessing calendar
        driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");

        // get current time
        LocalDateTime l = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTime = l.format(formatter);
        String[] dtTime = dateTime.split(" ");
        String time = dtTime[1];
        String[] t = time.split(":");
        String hour = t[0];
        String minute = t[1];

        // identify element to get calendar
        WebElement f = driver.findElement(By.xpath("//*[@id='datetimepicker2']"));
        f.click();

        // selecting hour based on current
        WebElement hours = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/input"));

        // removing existing hour then entering
        hours.clear();
        hours.sendKeys(hour);

        // selecting minutes based on current minutes
        WebElement minutes = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/input"));

        // removing existing minutes then entering
        minutes.clear();
        minutes.sendKeys(minute);

        // reflecting both date and time
        f.click();

        // get date and time selected
        String v = f.getDomProperty("value");
        System.out.println("Date and time selected by Date Time Picker: " + v);

        // check date and time selected
        if (v.equalsIgnoreCase(dateTime)){
            System.out.print("Date and Time selected successfully");
        } else {
            System.out.print("Date and Time selected unsuccessfully");
        }

        // close browser
        driver.quit();
    }
}
