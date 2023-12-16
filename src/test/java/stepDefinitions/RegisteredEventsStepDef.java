package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class RegisteredEventsStepDef extends CommonPage {
    @When("user clicks on the Registered Events")
    public void user_clicks_on_the_registered_events() {
        getEventsPage().registeredEventsButton.click();
    }

    @Then("verify that related page is opened and  all the Registered Events are displayed")
    public void verify_that_related_page_is_opened_and_all_the_registered_events_are_displayed() {
        ReusableMethods.waitFor(3);
        for (int i = 0; i < getEventsPage().registeredEventsChart.size(); i++) {
            Assert.assertTrue(getEventsPage().registeredEventsChart.get(i).isDisplayed());
        }
    }

    @Then("verify that in the Registered Events cart, headers are visible")
    public void verify_that_in_the_registered_events_cart_headers_are_visible() {
        ReusableMethods.waitFor(3);
        for (int i = 0; i < getEventsPage().registeredEventsTitles.size(); i++) {
            Assert.assertTrue(getEventsPage().registeredEventsTitles.get(i).isDisplayed());
            System.out.println("getEventsPage().registeredEventsTitles.get(i).getText() = " + getEventsPage().registeredEventsTitles.get(i).getText());
        }

    }

    @Then("verify that in the Registered Events cart, all modules are visible")
    public void verify_that_in_the_registered_events_cart_all_modules_are_visible(DataTable dataTable) {
        ReusableMethods.waitFor(3);
        List<String> chartModules = dataTable.column(0);

        for (int i = 0; i < chartModules.size(); i++) {

            WebElement element = Driver.getDriver().findElement(By.xpath("(//div//h6[contains(text(),'Available')])[3]/../..//h6[contains(text(),'" + chartModules.get(i) + "')]"));
            //div//h6[contains(text(),'Available')]/../..//h6[contains(text(),'Date')]

            Assert.assertTrue(element.getText().contains(chartModules.get(i)));
            System.out.println(element.getText() + "********");

        }


    }

    @Then("verify that in the Registered Events cart, Cancel button should be visible and clickable")
    public void verify_that_in_the_registered_events_cart_cancel_button_should_be_visible_and_clickable() {
        ReusableMethods.waitFor(3);
        getEventsPage().button_Cancel.isDisplayed();
        getEventsPage().button_Cancel.isEnabled();
    }

    @When("I clicked on the Cancel button")
    public void i_clicked_on_the_cancel_button() {
        getEventsPage().button_Cancel.click();
    }

    @Then("user verify Yes and No button is visible and clickable")
    public void user_verify_yes_and_no_button_is_visible_and_clickable() {
        getEventsPage().button_CancelNo.isDisplayed();
        getEventsPage().button_CancelNo.isEnabled();
        getEventsPage().button_CancelYes.isDisplayed();
        getEventsPage().button_CancelYes.isEnabled();
    }

    @When("user clicks on the No button")
    public void user_clicks_on_the_no_button() {
        getEventsPage().button_CancelNo.click();
    }

    @Then("user verify cannot delete the Registered Events")
    public void user_verify_cannot_delete_the_registered_events() {
        Assert.assertTrue(getEventsPage().registeredEventsChart.get(1).isDisplayed());
    }

    @When("user clicks on the Yes button")
    public void user_clicks_on_the_yes_button() {

    }

    @Then("user verify Registered Events deleted")
    public void user_verify_registered_events_deleted() {

    }

}
