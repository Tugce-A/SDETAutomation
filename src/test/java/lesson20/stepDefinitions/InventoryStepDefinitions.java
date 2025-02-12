package lesson20.stepDefinitions;

import io.cucumber.java.en.Then;
import lesson20.pages.InventoryPage;


public class InventoryStepDefinitions {

    InventoryPage inventoryPage = new InventoryPage();;

    @Then("Products header should visible on the inventory page")
    public void products_header_should_visible_on_the_inventory_page() {

        inventoryPage.productsTextAssertion();
    }
}
