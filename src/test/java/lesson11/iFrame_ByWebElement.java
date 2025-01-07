package lesson11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class iFrame_ByWebElement {
    public static void main(String[] args) {
        // Instantiate the EdgeDriver to launch the Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the specified URL containing iframes
        driver.get("https://demoqa.com/frames");

        // Locate the iframe element on the web page using its 'width' attribute
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='100px']"));

        // Switch the WebDriver's context to the located iframe
        driver.switchTo().frame(iframe);

        // Locate the header element within the iframe by its 'id'
        WebElement header1 = driver.findElement(By.id("sampleHeading"));

        // Print the text content of the located header element
        System.out.println(header1.getText());

        // Best practice: Add driver.quit() to close the browser after execution
        //driver.quit();
    }
}
