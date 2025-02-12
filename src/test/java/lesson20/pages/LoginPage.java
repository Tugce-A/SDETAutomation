package lesson20.pages;

import lesson20.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    @FindBy(id="user-name")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h4[contains(text(),'Accepted usernames are:')]")
    private WebElement acceptedUsernamesText;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement invalidCredentialsErrorMessage;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void setValidUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void setInvalidUsername(String username){
        usernameInput.sendKeys(username);
    }


    public void setValidPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void setInValidPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public void errorMessageForInvalidCredentials(){
        Assert.assertEquals("Epic sadface: Username and password do not match wwwqany user in this service",invalidCredentialsErrorMessage.getText());
    }

}
