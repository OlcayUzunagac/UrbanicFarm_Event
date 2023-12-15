package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Events;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import java.util.List;

public class ScheduledEventsStepDef extends CommonPage {
    @Given("user navigates to home page")
    public void userNavigatesToHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user clicks on the login module")
    public void userClicksOnTheLoginModule() {
        getEventsPage().loginModule.click();

    }

    @And("user enters seller's username and password")
    public void userEntersSellerSUsernameAndPassword() {
        ReusableMethods.waitFor(3);
        getEventsPage().emailInputBox.sendKeys(ConfigurationReader.getProperty("username"));
        ReusableMethods.waitFor(3);
        getEventsPage().passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        getEventsPage().loginButton.click();
    }
    @And("user enters zipCode and clicks Go button")
    public void userEntersZipCodeAndClicksGoButton() {
        ReusableMethods.waitFor(3);
        getEventsPage().zipCodeInputBox.sendKeys("95170");
        getEventsPage().goButton.click();
    }

    @And("user clicks on the Events module on the side bar")
    public void userClicksOnTheEventsModuleOnTheSideBar() {
        ReusableMethods.waitFor(5);
       //ReusableMethods.scrollToElement(getEventsPage().eventModule);
        JS_utilities.scrollAllUpByJS();
       //JS_utilities.scrollIntoViewJS(getEventsPage().eventModule);
        getEventsPage().eventModule.click();
    }

    @Then("verify that {string}, {string} and {string} titles are visible and clickable")
    public void verifyThatAndTitlesAreVisibleAndClickable(String scheduledEvents, String registeredEvents, String attendedEvents) {
        ReusableMethods.waitFor(3);
        Assert.assertEquals(scheduledEvents,getEventsPage().scheduledEventsButton.getText());
        Assert.assertEquals(registeredEvents,getEventsPage().registeredEventsButton.getText());
        Assert.assertEquals(attendedEvents, getEventsPage().attendedEventsButton.getText());
        Assert.assertTrue(getEventsPage().scheduledEventsButton.isEnabled());
        Assert.assertTrue(getEventsPage().registeredEventsButton.isEnabled());
        Assert.assertTrue(getEventsPage().attendedEventsButton.isEnabled());


    }

    @When("user clicks on the Scheduled events,")
    public void userClicksOnTheScheduledEvents() {
        ReusableMethods.waitFor(3);
        getEventsPage().scheduledEventsButton.click();
    }

    @Then("verify that related page is opened and  all the scheduled events are displayed")
    public void verifyThatRelatedPageIsOpenedAndAllTheScheduledEventsAreDisplayed() {
        ReusableMethods.waitFor(3);
        for (int i = 0; i < getEventsPage().scheduledEventsChart.size(); i++) {
            getEventsPage().scheduledEventsChart.get(i).isDisplayed();

        }

    }

    @And("verify that In the Scheduled events cart, headers are visible")
    public void verifyThatInTheScheduledEventsCartHeadersAreVisible() {
        ReusableMethods.waitFor(3);
        for (int i = 0; i < getEventsPage().scheduledEventsTitles.size(); i++) {
            getEventsPage().scheduledEventsTitles.get(i).isDisplayed();
            System.out.println("getEventsPage().scheduledEventsTitles = " + getEventsPage().scheduledEventsTitles);

        }
    }

    @And("verify that In the Scheduled events cart, all modules are visible")
    public void verifyThatInTheScheduledEventsCartAllModulesAreVisible(DataTable dataTable) {
        ReusableMethods.waitFor(3);
        List <String> chartModules= dataTable.column(0);
        int count = 0;
        for (int i = 0; i < chartModules.size(); i++) {

            WebElement element = Driver.getDriver().findElement(By.xpath("//h6[.='"+ chartModules+"']"));
           Assert.assertEquals(6, element.getSize());
            //Assert.assertEquals(chartModules.get(i),element.getText());
            System.out.println(count + ".element = " + element.getText());
            count++;


        }


    }

    @And("verify that In the Scheduled events cart, Registered button should be visible and clickable")
    public void verifyThatInTheScheduledEventsCartRegisteredButtonShouldBeVisibleAndClickable() {
        ReusableMethods.waitFor(3);
        getEventsPage().registerButton.isDisplayed();
        getEventsPage().registerButton.isEnabled();
    }

    @When("I clicked on the Register button")
    public void iClickedOnTheRegisterButton() {
        ReusableMethods.waitFor(3);
        getEventsPage().registerButton.click();
    }

    @Then("verify that Event Registration cart is opened")
    public void verifyThatEventRegistrationCartIsOpened() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(getEventsPage().eventRegistrationTitle.isDisplayed());
        System.out.println(getEventsPage().eventRegistrationTitle.getText());
    }



}
