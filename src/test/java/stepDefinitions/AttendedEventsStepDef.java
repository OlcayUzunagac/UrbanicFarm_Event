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

public class AttendedEventsStepDef extends CommonPage {
    @When("user clicks on the Attended Events")
    public void user_clicks_on_the_attended_events() {
        getEventsPage().attendedEventsButton.click();
    }
    @Then("verify that related page is opened and  all the Attended Events are displayed")
    public void verify_that_related_page_is_opened_and_all_the_attended_events_are_displayed() {
        ReusableMethods.waitFor(3);
        for (int i = 5; i < getEventsPage().attendedEventsChart.size(); i++) {
            Assert.assertTrue(getEventsPage().attendedEventsChart.get(i).isDisplayed());
        }
    }
    @Then("verify that in the Attended Events cart, headers are visible")
    public void verify_that_in_the_attended_events_cart_headers_are_visible() {
        ReusableMethods.waitFor(3);
        for (int i = 5; i < getEventsPage().attendedEventsTitles.size(); i++) {
            Assert.assertTrue(getEventsPage().attendedEventsTitles.get(i).isDisplayed());
            System.out.println("getEventsPage().registeredEventsTitles.get(i).getText() = " + getEventsPage().attendedEventsTitles.get(i).getText());
        }
    }
    @Then("verify that in the Attended Events cart, all modules are visible")
    public void verify_that_in_the_attended_events_cart_all_modules_are_visible(DataTable dataTable) {
        ReusableMethods.waitFor(3);
        List<String> chartModules = dataTable.column(0);
        int index=8;
        for (int i = 0; i < chartModules.size(); i++) {

            WebElement element = Driver.getDriver().findElement(By.xpath("(//h6[contains(text(),'" + chartModules.get(i) + "')])["+index+"]"));
                                                                                     //  (//h6[contains(text(),'Date:')])[8]
            Assert.assertTrue(element.getText().contains(chartModules.get(i)));
            System.out.println(element.getText() + "********");

        }

    }

}
