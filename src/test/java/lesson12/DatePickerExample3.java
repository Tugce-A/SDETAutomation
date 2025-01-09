package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerExample3 {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Resize the browser window
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1280, 720));

            // Navigate to the date picker site
            driver.get("https://fengyuanchen.github.io/datepicker/");

            // Open the date picker
            WebElement dateInput = driver.findElement(By.name("date"));
            dateInput.click();

            // Calculate tomorrow's date
            LocalDate today = LocalDate.now();
            LocalDate tomorrow = today.plusDays(1);

            // If the month changes, click the "next" button on the date picker
            if (tomorrow.getMonthValue() != today.getMonthValue()) {
                driver.findElement(By.xpath("//ul/li[@data-view='month next']")).click();
            }

            // Select tomorrow's day
            int dayTomorrow = tomorrow.getDayOfMonth();
            driver.findElement(By.xpath("//ul[@data-view='days']/li[text()=" + dayTomorrow + "]")).click();

            // Deselect the date picker
            driver.findElement(By.tagName("body")).click();

            // Verify the selected date
            String result = dateInput.getDomProperty("value");
            String expectedDate = tomorrow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            if (expectedDate.equals(result)) {
                System.out.println("Test Passed: Selected date is " + result);
            } else {
                System.out.println("Test Failed: Expected " + expectedDate + " but got " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
              //  driver.quit();
            }
        }
    }
