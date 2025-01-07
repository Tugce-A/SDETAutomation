package lesson10homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvancedMouseAndKeyboardActions {

    public static void main(String[] args) {
           performTask6_1_DragandDrop();
           performTask6_2_MouseAction();
           performTask6_3_Hover();
    }

    public static void performTask6_1_DragandDrop() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open URL
        driver.get("https://jqueryui.com/droppable/#default");

        // Switch to iframe containing drag and drop elements
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        //dragging an element first, then doing another action: build() method is used
        actions.dragAndDrop(source, target).build().perform();
        // Validate the success message
        String targetText = target.getText();
        if (targetText.equals("Dropped!")) {
            System.out.println("Task 6.1: Drag and Drop successful!");
        } else {
            System.out.println("Task 6.1: Drag and Drop failed.");
        }

        // Switch back to the main content
        driver.switchTo().defaultContent();
    }

    public static void performTask6_2_MouseAction() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open URL
        driver.get("https://demoqa.com/buttons");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit Wait


        // Double-click action
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", doubleClickButton);

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

        WebElement doubleClickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        System.out.println("Task 6.2: Double Click - " + doubleClickMessage.getText());

        // Right-click action
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();

       WebElement rightClickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
        System.out.println("Task 6.2: Right Click - " + rightClickMessage.getText());

        // Single click action
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickButton.click();

        WebElement clickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
        System.out.println("Task 6.2: Single Click - " + clickMessage.getText());
    }

    public static void performTask6_3_Hover() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open URL
        driver.get("https://demoqa.com/tool-tips");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit Wait

        // Hover action
        WebElement hoverButton = driver.findElement(By.id("toolTipButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hoverButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        WebElement hoverButtonTooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonToolTip")));
        System.out.println("Hover Button Tooltip text is: " + hoverButtonTooltip.getText());
        System.out.println("Hover Button's text is: " + hoverButton.getText());

        // Chained Actions: Hover followed by a click
        WebElement otherElement = driver.findElement(By.linkText("Contrary")); // Example of another element
        actions.moveToElement(hoverButton).moveToElement(otherElement).perform();
        WebElement ContraryLinkToolTip = driver.findElement(By.id("contraryTexToolTip"));
        System.out.println("ContraryLink Tooltip text is: " + ContraryLinkToolTip.getText());

        System.out.println("Task 6.3: Hover and click action completed.");
    }
}
