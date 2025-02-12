package lesson20.pages;

import lesson20.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CucumberReportPage {

    public CucumberReportPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@aria-label='Tümünü Kabul Et']")
    public WebElement cookies;
}
