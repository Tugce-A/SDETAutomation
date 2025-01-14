package lesson12homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimePickerInteraction {

    public static void main(String[] args) {

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Task 1.1: Select Current Date
            selectDate(driver, "https://jqueryui.com/datepicker/", LocalDate.now());

            // Task 1.2: Select 1st June 2025
            selectDate(driver, "https://jqueryui.com/datepicker/", LocalDate.of(2025, 6, 1));

            // Task 1.3: Select 5th November 2024
            selectDate(driver, "https://jqueryui.com/datepicker/", LocalDate.of(2024, 11, 5));

        } finally {
            // Close the WebDriver
            //driver.quit();
        }
    }

    public static void selectDate(WebDriver driver, String url, LocalDate dateToSelect) {
        // Navigate to the page
        driver.get(url);

        // Switch to iframe containing the date picker
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Locate the date picker input field and click it to open the calendar
        WebElement dateInput = driver.findElement(By.id("datepicker"));
        dateInput.click();

        // Format the desired date as per the date picker format (e.g., MM/dd/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = dateToSelect.format(formatter);




        // Use JavaScript to set the date value programmatically
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(
                "arguments[0].value='" + formattedDate + "';", dateInput);

        // Print the selected date from the input field to verify
        System.out.println("Selected Date: " + dateInput.getDomProperty("value"));
    }
}
