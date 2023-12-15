package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ScheduledEventsStepDef {
    @Given("user navigates to home page")
    public void userNavigatesToHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));



    }

    @When("user clicks on the login module")
    public void userClicksOnTheLoginModule() {
    }

    @And("user enters seller's username and password")
    public void userEntersSellerSUsernameAndPassword() {
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
    }

    @And("user clicks on the Events module on the side bar")
    public void userClicksOnTheEventsModuleOnTheSideBar() {
    }
}
