package stepDefinitions;

import io.cucumber.java.en.*;
import pages.CommonPage;

public class RegisteredEventsStepDef extends CommonPage {
    @When("user clicks on the Registered Events")
    public void user_clicks_on_the_registered_events() {
        getEventsPage().registeredEventsButton.click();
    }
    @Then("verify that related page is opened and  all the Registered Events are displayed")
    public void verify_that_related_page_is_opened_and_all_the_registered_events_are_displayed() {

    }
    @Then("verify that in the Registered Events cart, headers are visible")
    public void verify_that_in_the_registered_events_cart_headers_are_visible() {

    }
    @Then("verify that in the Registered Events cart, all modules are visible")
    public void verify_that_in_the_registered_events_cart_all_modules_are_visible(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("verify that in the Registered Events cart, Cancel button should be visible and clickable")
    public void verify_that_in_the_registered_events_cart_cancel_button_should_be_visible_and_clickable() {

    }
    @When("I clicked on the Cancel button")
    public void i_clicked_on_the_cancel_button() {

    }
}
