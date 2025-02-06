package lesson18.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    @Given("go to login page")
    public void go_to_login_page() {
        System.out.println("hello world");
    }

    @And("type valid username on login page")
    public void type_valid_username_on_login_page() {
        System.out.println("hello world");

    }

    @And("type valid password on login page")
    public void type_valid_password_on_login_page() {
        System.out.println("hello world");

    }

    @When("click login button on login page")
    public void click_login_button_on_login_page() {
        System.out.println("hello world");

    }

    @Then("Products header should visible on the inventory page")
    public void products_header_should_visible_on_the_inventory_page() {
        System.out.println("hello world");

    }
}
