package lesson19.pages;

import lesson19.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoryPage {
    public InventoryPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productsText;

    public void productsTextAssertion(){
        Assert.assertEquals("Products",productsText.getText());
        System.out.println("login is successful");
    }

}
