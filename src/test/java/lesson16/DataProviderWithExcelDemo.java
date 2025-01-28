package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderWithExcelDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Start test");
        driver = new ChromeDriver();
        driver.get("https://www.bing.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
    public void search(String keyWord1, String keyWord2) throws InterruptedException {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement txtBox = driver.findElement(By.cssSelector("#sb_form_q"));
        txtBox.sendKeys(keyWord1, " ", keyWord2);
        System.out.println("Keyword entered is : " + keyWord1 + " " + keyWord2);
        Thread.sleep(1000);
        txtBox.sendKeys(Keys.ENTER);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/nav[1]/ul[1]/li[1]/a[1]")));
        System.out.println("Search results are displayed.");
        System.out.println("RESULT: "+ driver.getTitle());
        Assert.assertTrue(driver.getPageSource().contains(keyWord1));
    }

    @AfterMethod
    public void burnDown() {
       driver.quit();
    }

}