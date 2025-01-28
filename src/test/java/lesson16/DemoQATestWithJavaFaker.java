package lesson16;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DemoQATestWithJavaFaker {

    private WebDriver driver;
    private Faker faker;

    @BeforeClass
    public void setup() {
        // Set up the ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        // Initialize Faker for Turkish locale
        faker = new Faker(new Locale("tr"));

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the form page
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillAndSubmitForm() {
        // Generate fake data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().subscriberNumber(10);
        String address = faker.address().fullAddress();

        // Fill out the form
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);

        // Select gender
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        // Fill phone number
        driver.findElement(By.id("userNumber")).sendKeys(phone);

        // Select date of birth (e.g., 15th of the month)
        WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
        dobInput.click();
        driver.findElement(By.cssSelector(".react-datepicker__day--015")).click();

        // Enter subject
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys("Mathematics");
        subjectInput.sendKeys("\n");


    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            //driver.quit();
        }
    }
}
