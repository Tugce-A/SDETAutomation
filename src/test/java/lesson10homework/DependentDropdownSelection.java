package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DependentDropdownSelection {
    public static void main(String[] args) {
        // scenario1LoseGame();
        scenario2WinGame();
    }

    public static void scenario1LoseGame() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the Exercise 4 page
        String url = "https://qbek.github.io/selenium-exercises/en/selects.html";
        driver.get(url);

        // Set up an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Scenario 1: User can lose the game
            System.out.println("Scenario 1: User can lose the game");

            // Select a wrong answer from the dropdown
            WebElement firstDropdown = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[1]"));
            Select selectFirstDropDown = new Select(firstDropdown);
            selectFirstDropDown.selectByValue("3"); // Choosing a wrong answer

            // Confirm the answer
            WebElement confirmButton = driver.findElement(By.cssSelector("button.btn"));
            confirmButton.click();

            // Verify failure banner
            WebElement failureBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//strong[(text()='You loose! Try again!')]")
            ));

            if (failureBanner.isDisplayed()) {
                System.out.println("You loose! Try again! .Test successful.");
            } else {
                System.out.println("Failure banner not displayed. Test failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser and end the session
            //  driver.quit();
        }
    }

    public static void scenario2WinGame() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the Exercise 4 page
        String url = "https://qbek.github.io/selenium-exercises/en/selects.html";
        driver.get(url);

        // Set up an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Scenario 2: User can win the game
            System.out.println("Scenario 2: User can win the game");

            // Select a 4 from the first dropdown
            WebElement firstDropdown = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[1]"));
            Select selectFirstDropDown = new Select(firstDropdown);
            selectFirstDropDown.selectByValue("4"); // Choosing a wrong answer

            // Click the confirm button
            WebElement firstConfirmButton = driver.findElement(By.cssSelector("button.btn"));
            firstConfirmButton.click();

            // Select "Nisi ut aliquid ex ea comm consequr?" from the dropdown
            WebElement secondDropdown = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[2]"));
            Select selectSecondDropdown = new Select(secondDropdown);
            selectSecondDropdown.selectByValue("words-7"); // Choosing a wrong answer

            // Confirm the answer
            WebElement secondConfirmButton = driver.findElement(By.xpath("//div[@id='question2']//button[@type='submit']"));
            secondConfirmButton.click();

            // Select "Carrot" from the dropdown
            WebElement thirdDropdown = driver.findElement(By.xpath("(//select[@class='custom-select mb-3'])[3]"));
            Select selectThirdDropdown = new Select(thirdDropdown);
            selectThirdDropdown.selectByVisibleText("Carrot"); // Choosing a wrong answer

            // Confirm the answer
            WebElement thirdConfirmButton = driver.findElement(By.xpath("//div[@id='question3']//button[@type='submit'][normalize-space()='Confirm']"));
            thirdConfirmButton.click();

            // The response to the third question differs with each selection:
            // Verify success banner
            WebElement successfulBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//strong[contains(text(),\"Congratulations!!! You've won 1 000 000\")]")
            ));
            if (successfulBanner.isDisplayed()) {
                System.out.println("Successful banner displayed. User win the game.");
            } else {
                System.out.println("Successful banner not displayed. Test failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser and end the session
            //  driver.quit();
        }
    }
}