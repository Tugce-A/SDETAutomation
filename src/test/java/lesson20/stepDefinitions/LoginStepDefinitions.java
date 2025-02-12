package lesson20.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson20.pages.LoginPage;
import lesson20.utilities.Driver;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("go to login page")
    public void go_to_login_page() {
       Driver.getDriver().manage().window().maximize();
       Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       Driver.getDriver().get("https://www.saucedemo.com/");
       System.out.println("Saucedemo login page is navigated");

    }

    @And("type valid username on login page")
    public void type_valid_username_on_login_page() {
        loginPage.setValidUsername("standard_user");
        System.out.println("valid username is filled");
    }

    @And("type valid password on login page")
    public void type_valid_password_on_login_page() {
        loginPage.setValidPassword("secret_sauce");
        System.out.println("valid password is filled");
    }

    @When("click login button on login page")
    public void click_login_button_on_login_page() {
        loginPage.clickLoginButton();
        System.out.println("login button is clicked");
    }


    @And("type invalid username on login page")
    public void typeInvalidUsernameOnLoginPage() {
        loginPage.setInvalidUsername("Invalid username");
        System.out.println("username is filled");
    }

    @Then("error message is displayed on the login page")
    public void errorMessageIsDisplayedOnTheLoginPage() {
        loginPage.errorMessageForInvalidCredentials();
        System.out.println("error message is displayed");
    }

    @And("user types username as {string}")
    public void userTypesUsernameAs(String username) {
        loginPage.setValidUsername(username);
        System.out.println("valid username is filled");

    }

    @And("user types password as {string}")
    public void userTypesPasswordAs(String password) {
        loginPage.setValidPassword(password);
        System.out.println("valid password is filled");
    }

    @Given("initialize webdriver")
    public void initializeWebdriver() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("type {string} username on login page")
    public void typeUsernameOnLoginPage(String invalidUsername) {
        loginPage.setInvalidUsername(invalidUsername);
    }

    @And("type {string} password on login page")
    public void typePasswordOnLoginPage(String invalidPassword) {
        loginPage.setInValidPassword(invalidPassword);
    }
}
