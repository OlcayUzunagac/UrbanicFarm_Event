package stepDefinitions;

import enums.URBANICFARM_CREDENTIALS;
import io.cucumber.java.en.When;
import io.restassured.response.*;
import utilities.Authentication;


import static io.restassured.RestAssured.given;

public class API_Events {

    Response response;
    @When("user makes a request and gets all Scheduled Events")
    public void user_makes_a_request_and_gets_all_scheduled_events() {
        response = given()
                .header("cookie", Authentication.generateCookieDynamicWithEnum(URBANICFARM_CREDENTIALS.SELLER))
                .post("https://test.hypnotes.net/api/question/getAllQuestionCategory");
        response.prettyPrint();

    }

}
