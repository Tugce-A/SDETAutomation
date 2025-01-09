package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesNumberOfRowsAndColumns{
    public static void main(String[] args) {
        numberOfColAndRows();
    }

    public static void numberOfColAndRows() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " + col.size());
        //No.of rows
        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());
        //driver.close();
    }
}
