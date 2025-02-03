package lesson17.ExamplePOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;

    // When creating a page class, a constructor must be created
    // to assign an initial value to the driver (instantiate it).
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(tagName = "img")
    public WebElement urunGorseli;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(id = "searchDropdownBox")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement ilkUrunIsim;

    // First method:
    // WebElement searchBox2 = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

    // Second method - Found the locator using the Page Object Model.
    By searchBox3 = By.cssSelector("#twotabsearchtextbox");
    public void searchBox3() {
        driver.findElement(searchBox3).sendKeys("nutella");
    }

    // Third method - PageFactory method
    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;
}
